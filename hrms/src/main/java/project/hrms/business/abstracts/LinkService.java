package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
}
