package com.api.config.security;

import com.api.model.UsuarioNovoModel;
import com.api.repository.UsuarioNovoRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    public String secret;
    @Value(("${api.security.token.issuer}"))
    public String issuer;
    @Autowired
    private UsuarioNovoRepository repository;

    public String gerarToken(UsuarioNovoModel usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            Map<String, Object> claims = new HashMap<>();
            claims.put("name", usuario.getusuarioNome());
            claims.put("email", usuario.getusuarioEmail());
            claims.put("id", usuario.getusuarioId());

            return JWT.create()
                    .withIssuer(issuer)
                    .withExpiresAt(dataExpiracao())
                    .withClaim("user", claims)
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String gerarRefreshToken(UsuarioNovoModel usuario) {
        try {
            String refresh = JWT.create().withIssuer(issuer)
                    .withExpiresAt(dataExpiracaoRefresh())
                    .sign(Algorithm.HMAC256(secret));

            usuario.setUsuarioRefreshToken(refresh);

            repository.save(usuario);

            return refresh;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar refresh token", e);
        }
    }


    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            DecodedJWT decodedJWT = JWT.require(algoritmo)
                    .withIssuer(issuer)
                    .build()
                    .verify(tokenJWT);

            Claim userClaim = decodedJWT.getClaim("user");
            String email = (String) userClaim.asMap().get("email");
            return String.valueOf(email);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");

        }
    }

    public String UseRefresh(String RefreshToken, String email) {
        try {
            var user = repository.findByUsuarioEmail(email);

            if (!user.getUsuarioRefreshToken().equals(RefreshToken)) {
                return null;
            }
            var algoritmo = Algorithm.HMAC256(secret);
            DecodedJWT decodedJWT = JWT.require(algoritmo)
                    .withIssuer("issuer")
                    .build()
                    .verify(RefreshToken);

            return gerarToken(user);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Refresh Token inválido ou expirado!");
        }
    }

    public void adicionarTokenNoHeader(HttpServletResponse response, String token) {
        response.setHeader(HttpHeaders.AUTHORIZATION, token);
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusMinutes(60).toInstant(ZoneOffset.of("-03:00"));
    }

    private Instant dataExpiracaoRefresh() {
        return LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00"));
    }
}