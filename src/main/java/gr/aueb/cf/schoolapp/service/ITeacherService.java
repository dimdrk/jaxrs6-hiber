package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.schoolapp.service.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Map;

public interface ITeacherService {
    TeacherReadOnlyDTO insertTeacher(TeacherReadOnlyDTO insertDTO) throws Exception;
    TeacherReadOnlyDTO updateTeacher(TeacherReadOnlyDTO updateDTO) throws EntityNotFoundException;
    void deleteTeacher(Object id) throws EntityNotFoundException;
    TeacherReadOnlyDTO getTeacherById(Object id) throws EntityNotFoundException;
    List<TeacherReadOnlyDTO> getAllTeachers() throws Exception;
    List<TeacherReadOnlyDTO> getTeachersByCriteria(Map<String, Object> criteria);
}
