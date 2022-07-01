package com.my.toyprj.member;
import com.my.toyprj.member.entity.Member;
import com.my.toyprj.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class memberTests {

    private MockMvc mockMvc;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void setUp(@Autowired WebApplicationContext applicationContext){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(applicationContext)
                .apply(springSecurity())
                .alwaysDo(print())
                .build();
    }

    @Test
    public void getCurrentMember_401() throws Exception{
        mockMvc.perform(post("/login/in"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    public void registerMember_401() throws Exception{
        mockMvc.perform(post("/login/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{test}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void findUserId(){
       Member member = memberRepository.findByUserId("제니");
        System.out.println(member.getUserId());
    }

}
