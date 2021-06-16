package com.devsuperior.bds02.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerDataIntegrityIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deleteShouldReturnBadRequestWhenDependentId() throws Exception {		

		Long dependentId = 1L;
		/* Para este caso, estamos testando a integridade relacional e como tem evento no cidade 1, então podemos apagar
		 * e tem que dar o erro abaixo. 
		 * Observe que neste arquivo não tem o @transactional como nos demais porque é assim que se far para testar a 
		 * integridade relacional. Este é o motivo para ter criado este arquivo. 
		 */
		ResultActions result =
				mockMvc.perform(delete("/cities/{id}", dependentId));
				
		result.andExpect(status().isBadRequest());
	}
}
