package med.voll.api.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = getToken(request);
        var subject = tokenService.getSubject(token);


        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request){
       String authorization = request.getHeader("Authorization");
       authorization = Objects.requireNonNull(authorization, "Token JWT não encontrado");
       return authorization.replace("Bearer ", "");
    };
}
