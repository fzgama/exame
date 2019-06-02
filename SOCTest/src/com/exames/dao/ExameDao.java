package com.exames.dao;

import java.util.List;

import com.exames.domain.Exame;

public interface ExameDao {

	public void saveOrUpdateExame(Exame exame);
	public List<Exame> listExame();
	public Exame listExame(Long id);
	public List<Exame> listExameByCpf(String cpf);
	public void deleteExame(Long id);
}
