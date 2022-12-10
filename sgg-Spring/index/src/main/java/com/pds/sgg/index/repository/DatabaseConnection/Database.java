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

/**
 * Classe de conexão dos controllers com o banco de dados
 */
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

    /**
     * Retorna todas as consultas de um paciente
     *
     * @param long Recebe um id do paciente
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Consulta> consultasFindByIdPaciente(long idPaciente){
        return consultasDB.getConsultasByIdPaciente(idPaciente);
    }

    /**
     * Retorna todas as consultas cadastradas
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Consulta> consultasGetAll(){
        return consultasDB.getAll();
    }

    /**
     * Salva a consulta no banco de dados
     *
     * @param Consulta Recebe um parâmetro da classe "Consulta"
     *
     * @return executa a query de salvar no banco de dados
     */
    public Consulta consultasSave(Consulta c){
        return consultasDB.save(c);
    }

    /**
     * Retorna todas uma consulta específica
     *
     * @param long Recebe um id da consulta
     *
     * @return executa a query de busca no banco de dados
     */
    public Consulta consultasFindById(long idConsulta){
        Optional<Consulta> opt = consultasDB.findById(idConsulta);
        return opt.isPresent() ? opt.get() : null;
    }

    /**
     * Deleta uma consulta específica
     *
     * @param long Recebe um id de uma consulta
     *
     * @return executa a query de deleção no banco de dados
     */
    public void consultasDeleteById(long idConsulta){
        consultasDB.deleteById(idConsulta);
    }      

    // FICHA ATENDIMENTO:

    /**
     * Salva a ficha de atendimento no banco de dados
     *
     * @param FichaAtendimento recebe a classe "FichaAtendimento" como parâmetro
     *
     * @return executa a query de salvar no banco de dados
     */
    public FichaAtendimento fichasAtendimentoSave(FichaAtendimento f){
        return fichaAtendimentoDB.save(f);
    }

    /**
     * Busca uma ficha de atendimento específica
     *
     * @param long Recebe o id de uma ficha de atendimento
     *
     * @return executa a query de busca no banco de dados
     */
    public FichaAtendimento fichasAtendimentoFindById(long idFichaAtendimento){
        Optional<FichaAtendimento> opt = fichaAtendimentoDB.findById(idFichaAtendimento);
        return opt.isPresent() ? opt.get() : null;
    }

    /**
     * Busca uma ficha de atendimento específica
     *
     * @param long Recebe o id de um paciente
     *
     * @return executa a query de busca no banco de dados
     */
    public List<FichaAtendimento> fichasAtendimentoFindByPaciente(long idFichaAtendimento){
        return fichaAtendimentoDB.getFichasAtendimentoByPaciente(idFichaAtendimento);
    }

    /**
     * Busca todas as fichas de atendimento
     *
     *
     * @return executa a query de busca no banco de dados
     */
    public List<FichaAtendimento> fichasAtendimentoGetAll(){
        return fichaAtendimentoDB.findAll();
    }

    /**
     * Deleta uma ficha no banco de dados
     *
     * @param long Recebe o id de uma ficha de atendimento
     *
     * @return executa a query de deleção no banco de dados
     */
    public void fichasAtendimentoDeleteById(long idFichaAtendimento){
        fichaAtendimentoDB.deleteById(idFichaAtendimento);
    }    

    // MEDICO:

    /**
     * Busca todos os médicos no banco de dados
     *
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Medico> medicoGetAll(){
        return medicoDB.findAll();
    }

    /**
     * Busca todos os médicos no banco de dados
     *
     * @param long Recebe o id de um médico
     *
     * @return executa a query de busca no banco de dados
     */
    public Medico medicoFindById(long idMedico){
        Optional<Medico> opt = medicoDB.findById(idMedico);
        return opt.isPresent() ? opt.get() : null;        
    }

    /**
     * Salva um médico no banco de dados
     *
     * @param Medico Recebe o parâmetro da classe "Medico"
     *
     * @return executa a query de salvar no banco de dados
     */
    public Medico medicoSave(Medico m){
        return medicoDB.save(m); 
    }

    /**
     * Deleta um médico do banco de dados
     *
     * @param long Recebe o id de um médico
     *
     * @return executa a query de deleção no banco de dados
     */
    public void medicoDeleteById(long idMedico){
        medicoDB.deleteById(idMedico);
    }        

    // EXAMES:

    /**
     * Busca um exame específico
     *
     * @param long Recebe o id de um exame
     *
     * @return executa a query de busca no banco de dados
     */
    public Exames examesFindById(long idExame){
        Optional<Exames> opt = examesDB.findById(idExame);
        return opt.isPresent() ? opt.get() : null;    
    }

    /**
     * Busca todos os exames de um paciente específico
     *
     * @param long Recebe o id de um paciente
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Exames> examesGetAllByPaciente(long id){
        return examesDB.getAllExamesByPaciente(id);
    }

    /**
     * Deleta um exame específico
     *
     * @param long Recebe o id de um exame
     *
     * @return executa a query de deleção no banco de dados
     */
    public void examesDeleteById(long idExame){
        examesDB.deleteById(idExame);
    }

    /**
     * Salva os exames no banco de dados
     *
     * @param long Recebe o parâmetro da classe "exames"
     *
     * @return executa a query de salvar no banco de dados
     */
    public Exames examesSave(Exames e){
        return examesDB.save(e);
    }        

    // PACIENTE:

    /**
     * Busca um paciente específico
     *
     * @param long Recebe o id de um paciente
     *
     * @return executa a query de busca no banco de dados
     */
    public Paciente pacienteFindById(long idPaciente){
        Optional<Paciente> opt = pacienteDB.findById(idPaciente);
        return opt.isPresent() ? opt.get() : null;    
    }

    /**
     * Busca todos os pacientes no banco de dados
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Paciente> pacienteGetAll(){
        return pacienteDB.findAll();
    }

    /**
     * Salva um paciente no banco de dados
     *
     * @param Paciente Recebe o parâmetro da classe "Paciente"
     *
     * @return executa a query de salvar no banco de dados
     */
    public Paciente pacienteSave(Paciente p){
        return pacienteDB.save(p);
    }

    /**
     * Deleta um paciente do banco de dados
     *
     * @param long Recebe o id de um paciente
     *
     * @return executa a query de deleção no banco de dados
     */
    public void pacienteDeleteById(long idPaciente){
        pacienteDB.deleteById(idPaciente);
    }        

    // PESSOA: 
    /**
     * Busca uma pessoa específica
     *
     * @param long Recebe o id de uma pessoa
     *
     * @return executa a query de busca no banco de dados
     */
    public Pessoa pessoaFindById(long idPessoa){
        Optional<Pessoa> opt = pessoaDB.findById(idPessoa);
        return opt.isPresent() ? opt.get() : null;    
    }

    /**
     * Busca todas as pessoas no banco de dados
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Pessoa> pessoasGetAll(){
        return pessoaDB.findAll();
    }

    /**
     * Salva uma pessoa no banco de dados
     *
     * @param Pessoa Recebe um parâmetro da classe "Pessoa"
     *
     * @return executa a query de salvar no banco de dados
     */
    public Pessoa pessoaSave(Pessoa p){
        return pessoaDB.save(p);
    }

    /**
     * Deleta uma pessoa do banco de dados
     *
     * @param long Recebe o id de uma pessoa
     *
     * @return executa a query de deleção no banco de dados
     */
    public void pessoaDeleteById(long idPessoa){
        pessoaDB.deleteById(idPessoa);
    }      
    
    // USUARIO: 

    /**
     * Busca um usuário específico
     *
     * @param long Recebe o id de um usuário
     *
     * @return executa a query de busca no banco de dados
     */
    public Usuario usuarioFindById(long idUsuario){
        Optional<Usuario> opt = usuarioDB.findById(idUsuario);
        return opt.isPresent() ? opt.get() : null;    
    }

    /**
     * Busca todos os usuários
     *
     * @return executa a query de busca no banco de dados
     */
    public List<Usuario> usuarioGetAll(){
        return usuarioDB.findAll();
    }

    /**
     * Salva um usuário no banco de dados
     *
     * @param Usuario Recebe um parâmetro da classe "Usuario"
     *
     * @return executa a query de salvar no banco de dados
     */
    public Usuario usuarioSave(Usuario u){
        return usuarioDB.save(u);
    }

    /**
     * Deleta um usuário do banco de dados
     *
     * @param long Recebe o id de um usuário
     *
     * @return executa a query de deleção no banco de dados
     */
    public void usuarioDeleteById(long idUsuario){
        usuarioDB.deleteById(idUsuario);
    }         

    // SET REPOSITORY:
    /**
     * Define o repositório das consultas
     */
    public void setConsultaRepository(ConsultaRepository cr){
        consultasDB = cr;
    }

    /**
     * Define o repositório das fichas de atendimento
     */
    public void setFichaAtendimentoRepository(FichaAtendimentoRepository far){
        fichaAtendimentoDB = far;
    }

    /**
     * Define o repositório dos exames
     */
    public void setExamesRepository(ExamesRepository er){
        examesDB = er;
    }

    /**
     * Define o repositório dos médicos
     */
    public void setMedicoRepository(MedicoRepository mr){
        medicoDB = mr;
    }
    /**
     * Define o repositório dos pacientes
     */
    public void setPacienteRepository(PacienteRepository pr){
        pacienteDB = pr;
    }
    /**
     * Define o repositório das pessoas
     */
    public void setPessoaRepository(PessoaRepository pr){
        pessoaDB = pr;
    }
    /**
     * Define o repositório dos usuários
     */
    public void setUsuarioRepository(UsuarioRepository ur){
        usuarioDB = ur;
    }         
}
