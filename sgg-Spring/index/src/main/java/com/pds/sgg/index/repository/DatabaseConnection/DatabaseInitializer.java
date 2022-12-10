package com.pds.sgg.index.repository.DatabaseConnection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pds.sgg.index.repository.UsuarioRepository;
import com.pds.sgg.index.repository.pessoa.PessoaRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ConsultaRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ExamesRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.FichaAtendimentoRepository;
import com.pds.sgg.index.repository.pessoa.medico.MedicoRepository;
import com.pds.sgg.index.repository.pessoa.paciente.PacienteRepository;

/**
 * Rest Controller responsável por inicializar a conexão com o banco de dados
 */
@RestController
public class DatabaseInitializer {
    @Autowired
    ConsultaRepository consultasDB;

    @Autowired
    FichaAtendimentoRepository fichaAtendimentoDB;

    @Autowired
    ExamesRepository examesDB;    

    @Autowired
    MedicoRepository medicoDB;  
    
    @Autowired
    PacienteRepository pacienteDB;    

    @Autowired
    PessoaRepository pessoaDB;    

    @Autowired
    UsuarioRepository usuarioDB;     

    @PostConstruct
    public void init() {
        Database.getInstance().setConsultaRepository(consultasDB);
        Database.getInstance().setFichaAtendimentoRepository(fichaAtendimentoDB);
        Database.getInstance().setExamesRepository(examesDB);
        Database.getInstance().setMedicoRepository(medicoDB);
        Database.getInstance().setPacienteRepository(pacienteDB);
        Database.getInstance().setPessoaRepository(pessoaDB);
        Database.getInstance().setUsuarioRepository(usuarioDB);
    } 
}
