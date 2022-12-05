package br.edu.fateczl.Hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.Hotel.controller.interfaces.Controller;
import br.edu.fateczl.Hotel.model.dto.ReservaServicoDTO;
import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.model.entity.ReservaServico;
import br.edu.fateczl.Hotel.model.entity.ReservaServicoID;
import br.edu.fateczl.Hotel.model.entity.Servico;
import br.edu.fateczl.Hotel.repository.ReservaServicoRepository;

@RestController
@RequestMapping("/api")
public class ReservaServicoController extends Controller<ReservaServicoDTO> {

	@Autowired
	ReservaServicoRepository rep;

	@Override
	@GetMapping("/reservaservico/")
	public List<ReservaServicoDTO> findAll() {
		List<ReservaServico> reservaServico = rep.findAll();
		List<ReservaServicoDTO> rs = new ArrayList<>();

		for (ReservaServico rSer : reservaServico) {
			rs.add(rSer.toDTO());
		}
		return rs;
	}

	@GetMapping("/reservaservico/{reservaservicoID}")
	public ResponseEntity<ReservaServicoDTO> findOne(@PathVariable(name = "documento") Reserva docPessoa,
			@PathVariable(name = "tipodocumento") Reserva tipoDoc, @PathVariable(name = "quartoid") Reserva quartoID,
			@PathVariable(name = "dataInicio") Reserva dataInicio, @PathVariable(name = "codigo") Servico codigo) {
		ReservaServicoID id = new ReservaServicoID();
		id.setDataInicio(dataInicio);
		id.setPessoaDocumento(docPessoa);
		id.setQuartoID(quartoID);
		id.setTipoDocumento(tipoDoc);
		id.setsID(codigo);
		Optional<ReservaServico> reservaServico = rep.findById(id);
		ReservaServico rs = reservaServico.orElseThrow(
				() -> new ResourceNotFoundException(notFound("uma reserva no serviço " + docPessoa, tipoDoc + "")));
		return ResponseEntity.ok().body(rs.toDTO());
	}

	@Override
	@PostMapping("/reservaservico")
	public ResponseEntity<String> insert(@Valid @RequestBody ReservaServicoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(1));
	}

	@Override
	@PutMapping("/reservaservico")
	public ResponseEntity<String> update(@Valid @RequestBody ReservaServicoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(2));
	}

	@Override
	@DeleteMapping("/reservaservico")
	public ResponseEntity<String> delete(@Valid @RequestBody ReservaServicoDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(3));
	}

	@Override
	public ResponseEntity<ReservaServicoDTO> findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}