package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Language;

public interface LanguageService {

	Result add(Language language);
}
