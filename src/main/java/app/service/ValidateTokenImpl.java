package app.service;


import org.springframework.stereotype.Service;

@Service
public class ValidateTokenImpl implements ValidateTokenService {

    private final TokenParser tokenParser;

    public ValidateTokenImpl(TokenParser tokenParser) {
        this.tokenParser = tokenParser;
    }

    public boolean validateToken(String token) {
        return tokenParser.parseToken(token);
    }
}
