package xulep.co.frutologiaapi.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import xulep.co.frutologiaapi.entity.Usuario;


import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECRET_JWT = "0785279d-d27a-48d3-8fe9-470740cc366b";
    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        //setFilterProcessesUrl("api/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {
        try {
            Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(), usuario.getPassword(), new ArrayList()
            ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)
            throws IOException, ServerException {

        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(userDetailsCustom.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+600000))
                .withClaim("codigo", 9)
                .withClaim("permissao", "ADMIN")
                .sign(Algorithm.HMAC256(SECRET_JWT));

        response.getWriter().write(token);
        response.getWriter().flush();

    }
}