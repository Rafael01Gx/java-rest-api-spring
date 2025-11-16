package med.voll.api.controllers;


import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.consulta.ConsultaService;
import med.voll.api.domain.consulta.DetalhesConsultaDto;
import med.voll.api.domain.medico.Especialidade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConsultaService consultaService;

    @Autowired
    private JacksonTester<AgendamentoConsultaDto> agendamentoConsultaDtoJson;
    @Autowired
    private JacksonTester<DetalhesConsultaDto> detalhesConsultaDtoJson;


    @Test
    @DisplayName("Deveria retornar codigo 400 quando informacoes estao invalidas")
    @WithMockUser
    void agendar_cenario1() throws Exception {
        var response = mockMvc.perform(post("/consultas"))
                .andReturn().getResponse();

        Assertions.assertEquals(400, response.getStatus());

    }

    @Test
    @DisplayName("Deveria retornar codigo 200 quando informacoes estao invalidas")
    @WithMockUser
    void agendar_cenario2() throws Exception {
        var data = LocalDateTime.now().plusDays(1);
        var detalheConsulta = new DetalhesConsultaDto(null, 2l, 5l, data);
        Mockito.when(consultaService.agendar(any())).thenReturn(detalheConsulta);
        var especialidade = Especialidade.CARDIOLOGIA;
        var response = mockMvc.perform(
                        post("/consultas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(agendamentoConsultaDtoJson.write(
                                        new AgendamentoConsultaDto(2l, 5l, data, especialidade)
                                ).getJson())
                )
                .andReturn().getResponse();


        var jsonEsperado = detalhesConsultaDtoJson.write(
                detalheConsulta
        ).getJson();

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(jsonEsperado,response.getContentAsString());

    }

}