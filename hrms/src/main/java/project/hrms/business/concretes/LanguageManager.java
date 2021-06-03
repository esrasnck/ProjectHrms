package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.LanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.LanguageDao;
import project.hrms.entities.concretes.Language;

@Service("LanguageManager")
public class LanguageManager implements LanguageService{

	
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}


	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Language added !");
	}


	@Override
	public DataResult<List<Language>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAllByCandidate_Id(candidateId));
	}

}
