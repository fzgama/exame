package com.exames.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.exames.domain.Exame;

public class ExameDaoImpl implements ExameDao {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Cria ou atualiza exame.
	 */
	public void saveOrUpdateExame(Exame exame) {
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(exame);
			session.flush();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Apaga exame.
	 */
	public void deleteExame(Long id) {
		try {
			Exame exame = (Exame) session.get(Exame.class, id);
			transaction = session.beginTransaction();
			session.delete(exame);
			session.flush();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Lista exames.
	 */
	@SuppressWarnings("unchecked")
	public List<Exame> listExame() {
		List<Exame> examesList = null;
		try {
			Query query = session.createQuery("from Exame");
			examesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesList;
	}

	/**
	 * Seleciona exame por id para exlcuir.
	 */
	public Exame listExame(Long id) {
		Exame exame = null;
		try {
			exame = (Exame) session.get(Exame.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exame;
	}

	/**
	 * Seleciona exame por cpf.
	 */
	public List<Exame> listExameByCpf(String cpf) {
		List<Exame> examesList = null;
		try {
			Query query = session.createQuery("from Exame where cpf = :cpf");
			query.setParameter("cpf", cpf);
			examesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesList;
	}	
	
}

