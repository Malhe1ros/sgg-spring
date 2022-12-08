package com.pds.sgg.index.repository.DatabaseConnection;

import java.util.List;
import java.util.Optional;

import com.pds.sgg.index.entity.Usuario;
import com.pds.sgg.index.entity.pessoa.Pessoa;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;
import com.pds.sgg.index.entity.pessoa.medico.Medico;
import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.repository.UsuarioRepository;
import com.pds.sgg.index.repository.pessoa.PessoaRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ConsultaRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ExamesRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.FichaAtendimentoRepository;
import com.pds.sgg.index.repository.pessoa.medico.MedicoRepository;
import com.pds.sgg.index.repository.pessoa.paciente.PacienteRepository;

public class Database {
    private static Database instance = null;

    ConsultaRepository consultasDB;
    FichaAtendimentoRepository fichaAtendimentoDB;
    ExamesRepository examesDB;
    MedicoRepository medicoDB;
    PacienteRepository pacienteDB; 
    PessoaRepository pessoaDB;    
    UsuarioRepository usuarioDB;   

    public synchronized static Database getInstance()
    {
        if (instance == null){
            instance = new Database();
        }
  
        return instance;
    }

    // CONSULTAS:

    public List<Consulta> consultasFindByIdPaciente(long idPaciente){
        return consultasDB.getConsultasByIdPaciente(idPaciente);
    }

    public List<Consulta> consultasGetAll(){
        return consultasDB.getAll();
    }

    public Consulta consultasSave(Consulta c){
        return consultasDB.save(c);
    }    

    public Consulta consultasFindById(long idConsulta){
        Optional<Consulta> opt = consultasDB.findById(idConsulta);
        return opt.isPresent() ? opt.get() : null;
    }       

    public void consultasDeleteById(long idConsulta){
        consultasDB.deleteById(idConsulta);
    }      

    // FICHA ATENDIMENTO:

    public FichaAtendimento fichasAtendimentoSave(FichaAtendimento f){
        return fichaAtendimentoDB.save(f);
    }    

    public FichaAtendimento fichasAtendimentoFindById(long idFichaAtendimento){
        Optional<FichaAtendimento> opt = fichaAtendimentoDB.findById(idFichaAtendimento);
        return opt.isPresent() ? opt.get() : null;
    }      

    public List<FichaAtendimento> fichasAtendimentoFindByPaciente(long idFichaAtendimento){
        return fichaAtendimentoDB.getFichasAtendimentoByPaciente(idFichaAtendimento);
    }

    public List<FichaAtendimento> fichasAtendimentoGetAll(){
        return fichaAtendimentoDB.findAll();
    }
    
    public void fichasAtendimentoDeleteById(long idFichaAtendimento){
        fichaAtendimentoDB.deleteById(idFichaAtendimento);
    }    

    // MEDICO:

    public List<Medico> medicoGetAll(){
        return medicoDB.findAll();
    }   

    public Medico medicoFindById(long idMedico){
        Optional<Medico> opt = medicoDB.findById(idMedico);
        return opt.isPresent() ? opt.get() : null;        
    }       

    public Medico medicoSave(Medico m){
        return medicoDB.save(m); 
    }         

    public void medicoDeleteById(long idMedico){
        medicoDB.deleteById(idMedico);
    }        

    // EXAMES:

    public Exames examesFindById(long idExame){
        Optional<Exames> opt = examesDB.findById(idExame);
        return opt.isPresent() ? opt.get() : null;    
    }

    public List<Exames> examesGetAllByPaciente(long id){
        return examesDB.getAllExamesByPaciente(id);
    }

    public void examesDeleteById(long idExame){
        examesDB.deleteById(idExame);
    }    

    public Exames examesSave(Exames e){
        return examesDB.save(e);
    }        

    // PACIENTE:

    public Paciente pacienteFindById(long idPaciente){
        Optional<Paciente> opt = pacienteDB.findById(idPaciente);
        return opt.isPresent() ? opt.get() : null;    
    }

    public List<Paciente> pacienteGetAll(){
        return pacienteDB.findAll();
    }   

    public Paciente pacienteSave(Paciente p){
        return pacienteDB.save(p);
    }     

    public void pacienteDeleteById(long idPaciente){
        pacienteDB.deleteById(idPaciente);
    }        

    // PESSOA: 

    public Pessoa pessoaFindById(long idPessoa){
        Optional<Pessoa> opt = pessoaDB.findById(idPessoa);
        return opt.isPresent() ? opt.get() : null;    
    }

    public List<Pessoa> pessoasGetAll(){
        return pessoaDB.findAll();
    }   

    public Pessoa pessoaSave(Pessoa p){
        return pessoaDB.save(p);
    }  

    public void pessoaDeleteById(long idPessoa){
        pessoaDB.deleteById(idPessoa);
    }      
    
    // USUARIO: 

    public Usuario usuarioFindById(long idUsuario){
        Optional<Usuario> opt = usuarioDB.findById(idUsuario);
        return opt.isPresent() ? opt.get() : null;    
    }

    public List<Usuario> usuarioGetAll(){
        return usuarioDB.findAll();
    }   

    public Usuario usuarioSave(Usuario u){
        return usuarioDB.save(u);
    }  

    public void usuarioDeleteById(long idUsuario){
        usuarioDB.deleteById(idUsuario);
    }         

    // SET REPOSITORY:

    public void setConsultaRepository(ConsultaRepository cr){
        consultasDB = cr;
    }

    public void setFichaAtendimentoRepository(FichaAtendimentoRepository far){
        fichaAtendimentoDB = far;
    }    

    public void setExamesRepository(ExamesRepository er){
        examesDB = er;
    }    

    public void setMedicoRepository(MedicoRepository mr){
        medicoDB = mr;
    }     

    public void setPacienteRepository(PacienteRepository pr){
        pacienteDB = pr;
    }        

    public void setPessoaRepository(PessoaRepository pr){
        pessoaDB = pr;
    }      
    
    public void setUsuarioRepository(UsuarioRepository ur){
        usuarioDB = ur;
    }         
}
