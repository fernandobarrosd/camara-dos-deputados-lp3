package com.fernando.camara_dos_deputados_lp3;

import com.fernando.camara_dos_deputados_lp3.dtos.EventoAPIDTO;
import com.fernando.camara_dos_deputados_lp3.dtos.UriAPIDTO;
import com.fernando.camara_dos_deputados_lp3.dtos.DeputadoAPIDTO;
import com.fernando.camara_dos_deputados_lp3.entities.Deputado;
import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import com.fernando.camara_dos_deputados_lp3.mappers.DeputadoMapper;
import com.fernando.camara_dos_deputados_lp3.mappers.EventoMapper;
import com.fernando.camara_dos_deputados_lp3.repositories.DeputadoRepository;
import com.fernando.camara_dos_deputados_lp3.repositories.EventoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class CamaraDosDeputadosLp3Application {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DeputadoMapper deputadoMapper;

	@Autowired
	private EventoMapper eventoMapper;

	@Autowired
	private DeputadoRepository deputadoRepository;

	@Autowired
	private EventoRepository eventoRepository;

	private static final String EXTERNAL_API_BASE_URL = "https://dadosabertos.camara.leg.br/api/v2";

	public static void main(String[] args) {
		SpringApplication.run(CamaraDosDeputadosLp3Application.class, args);
	}

	@PostConstruct
	public void insertDeputadosInDatabaseFromExternalAPI() {
		String deputadosRequestURL = String.format("%s/deputados?itens=10", EXTERNAL_API_BASE_URL);
		UriAPIDTO uriAPIDTO = restTemplate.getForObject(deputadosRequestURL, UriAPIDTO.class);
		List<UriAPIDTO.Info> infos = uriAPIDTO.getDados();

		List<Deputado> deputados = infos.stream()
				.map(info -> restTemplate.getForObject(info.getUri(),
				DeputadoAPIDTO.class))
				.map(deputadoMapper::toEntity)
				.toList();

		deputadoRepository.saveAll(deputados);
	}

	@PostConstruct
	public void insertEventosInDatabaseFromExternalAPI() {
		String deputadosRequestURL = String.format("%s/eventos?itens=40", EXTERNAL_API_BASE_URL);
		UriAPIDTO uriAPIDTO = restTemplate.getForObject(deputadosRequestURL, UriAPIDTO.class);
		List<UriAPIDTO.Info> infos = uriAPIDTO.getDados();

		List<Evento> eventos = infos.stream()
				.map(info -> restTemplate.getForObject(info.getUri(),
						EventoAPIDTO.class))
				.map(eventoMapper::toEntity)
				.toList();

		eventoRepository.saveAll(eventos);
	}

}
