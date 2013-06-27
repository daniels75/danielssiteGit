// Copyright 2012 Dragan Sahpaski
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.daniels.projects.site.services;

import java.util.List;

import javax.inject.Inject;


import org.daniels.projects.site.entities.Department;
import org.daniels.projects.site.entities.Employee;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EmployeeDAOImpl implements EmployeesDAO {

	@Inject
	private Session session;

	public Employee findById(Integer id) {
		return (Employee) session.load(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		return session.createCriteria(Employee.class)
				.addOrder(Order.asc("lastName"))
				.addOrder(Order.asc("firstName")).list();
	}

	@SuppressWarnings("unchecked")
	public List<Department> findAllDepartments() {
		return session.createCriteria(Department.class)
				.addOrder(Order.asc("name")).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll(Department department) {
		return session.createCriteria(Employee.class)
				.add(Restrictions.eq("department", department))

				.addOrder(Order.asc("lastName"))
				.addOrder(Order.asc("firstName")).list();

	}

	public Department findById(String code) {
		return (Department) session.load(Department.class, code);
	}

	public void save(Employee employee) {
		session.saveOrUpdate(employee);
	}
}
