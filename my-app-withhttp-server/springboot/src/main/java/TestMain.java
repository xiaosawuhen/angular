import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class TestMain {

	public static void main(String[] args) {
		Key key = MacProvider.generateKey();

//		String compactJws = Jwts.builder()
//		  .setSubject("Joe")
//		  .signWith(SignatureAlgorithm.HS256, key)
//		  .compact();
		
        String jwtToken = Jwts.builder()
        		.setHeaderParam("type", "jwt")
//        		.setAudience("Audience")
//        		.setExpiration(new Date())
//        		.setId("Id")
//        		.setIssuer("Issuer")
//        		.setNotBefore(new Date())
//        		.setPayload("123")
        		.setSubject("Subject")
//        		.claim("roles", "member")
//        		.setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
        
        Jws<Claims> claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(jwtToken);
        String sbuject = claims.getBody().getSubject();
//        System.out.println(sbuject);
        
        String compactJws =  Jwts.builder()
        	    .setSubject("Joe")
//        	    .compressWith(CompressionCodecs.DEFLATE)
        	    .signWith(SignatureAlgorithm.HS512, key)
        	    .compact();
		
        try {
            Jws<Claims> claims1 = Jwts.parser()
                .requireSubject("Joe")
//                .require("hasMotorcycle", true)
                .setSigningKey(key)
                .parseClaimsJws(compactJws);
            System.out.println(claims1.getBody().getSubject());
        } catch (MissingClaimException e) {

            // we get here if the required claim is not present

        } catch (IncorrectClaimException e) {

            // we get here if the required claim has the wrong value

        }
        
		System.out.println(compactJws);
	}
}
