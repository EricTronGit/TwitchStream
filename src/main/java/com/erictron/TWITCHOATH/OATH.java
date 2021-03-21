package com.erictron.TWITCHOATH;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OATH {
    public String access_token;
    public String expires_in;
    public String token_type;
}
