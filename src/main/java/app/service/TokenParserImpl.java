package app.service;

import org.springframework.stereotype.Service;

@Service
public class TokenParserImpl implements TokenParser {


    @Override
    public boolean parseToken(String token) {
        if(token.equals("a")){
            return true;
        }else {
            return false;
        }
    }
}
