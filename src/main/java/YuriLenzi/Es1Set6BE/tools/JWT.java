package YuriLenzi.Es1Set6BE.tools;

import YuriLenzi.Es1Set6BE.entities.Dipendente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWT {
    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Dipendente dipendente){
          return Jwts.builder()
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5))
                    .subject(dipendente.getUsername())
                    .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                    .compact();
    }
}
