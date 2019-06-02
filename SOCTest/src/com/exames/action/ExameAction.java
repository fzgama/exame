package com.exames.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.exames.dao.ExameDao;
import com.exames.dao.ExameDaoImpl;
import com.exames.domain.Exame;

public class ExameAction extends ActionSupport implements ModelDriven<Exame> {

	private static final long serialVersionUID = -6659925652584240539L;

	private Exame exame = new Exame();
	private List<Exame> exameList = new ArrayList<Exame>();
	private ExameDao exameDAO = new ExameDaoImpl();
	
	public Exame getModel() {
		return exame;
	}
	
	/**
	 * Atualiza ou salva exame.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		exameDAO.saveOrUpdateExame(exame);
		return SUCCESS;
	}
	
	/**
	 * Lista todos os exames por cpf.
	 * @return String
	 */
	public String list()
	{
		exameList = exameDAO.listExame();
		return SUCCESS;
	}
	
	/**
	 * Apaga exame.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		exameDAO.deleteExame(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * Seleciona exame para edição.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		exame = exameDAO.listExame(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * Seleciona exames por cpf.
	 * @return String
	 */
	public String listByCpf()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		exameList = exameDAO.listExameByCpf(request.getParameter("cpf"));
		return SUCCESS;
	}	
	
	
	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExameList() {
		return exameList;
	}

	public void setExameList(List<Exame> exameList) {
		this.exameList = exameList;
	}

}
