package uniProject.carShowroomManagementSystem.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniProject.carShowroomManagementSystem.business.RoleService;
import uniProject.carShowroomManagementSystem.constant.Messages;
import uniProject.carShowroomManagementSystem.converter.role.RoleConverter;
import uniProject.carShowroomManagementSystem.core.entity.Role;
import uniProject.carShowroomManagementSystem.core.util.result.*;
import uniProject.carShowroomManagementSystem.dataAccess.RoleDao;
import uniProject.carShowroomManagementSystem.dto.role.CreateRoleRequestDto;

@Service
@RequiredArgsConstructor
public class RoleManager implements RoleService {
	
	private final RoleDao roleDao;
	private final RoleConverter roleConverter;

	@Override
	public Result add(CreateRoleRequestDto createRoleRequestDto) {
		Role role = roleConverter.toRole(createRoleRequestDto);
		roleDao.save(role);
		return new SuccessResult(Messages.added);
	}
	
	@Override
	public Result delete(int id) {
		Role role = getById(id).getData();
		if(role == null) {
			return new ErrorResult(Messages.isNotExist);
		}
		roleDao.deleteById(id);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Role entity) {
		roleDao.save(entity);
		return new SuccessResult(Messages.added);
	}

	@Override
	public DataResult<Role> getById(int id) {
		Role role = roleDao.findById(id).orElse(null);
		if(role == null) {
			return new ErrorDataResult<Role>(null, Messages.isNotExist);
		}
		return new SuccessDataResult<Role>(role, Messages.viewed);
	}

	@Override
	public DataResult<List<Role>> getAll() {
		return new SuccessDataResult<List<Role>>(roleDao.findAll(), Messages.listed);
	}



}
