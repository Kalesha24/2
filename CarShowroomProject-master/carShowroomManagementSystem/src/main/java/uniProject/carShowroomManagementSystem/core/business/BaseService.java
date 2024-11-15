package uniProject.carShowroomManagementSystem.core.business;

import uniProject.carShowroomManagementSystem.core.util.result.DataResult;
import uniProject.carShowroomManagementSystem.core.util.result.Result;


public interface BaseService<T> {
	Result delete(int id);
	Result update(T entity);
	DataResult<T> getById(int id);
}
