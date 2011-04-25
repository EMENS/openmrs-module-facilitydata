/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.facilitydata.service.db;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Location;
import org.openmrs.module.facilitydata.model.FacilityDataQuestionType;
import org.openmrs.module.facilitydata.model.FacilityDataFormSchema;
import org.openmrs.module.facilitydata.model.FacilityDataQuestion;
import org.openmrs.module.facilitydata.model.FacilityDataValue;

/**
 * Core implementation of the DAO
 */
public class HibernateFacilityDataDAO implements FacilityDataDAO {
	
	//***** PROPERTIES *****
	
    private SessionFactory sessionFactory;

    //***** INSTANCE METHODS *****

	/**
	 * @see FacilityDataDAO#saveFacilityDataFormSchema(FacilityDataFormSchema)
	 */
	public FacilityDataFormSchema saveFacilityDataFormSchema(FacilityDataFormSchema formSchema) {
        sessionFactory.getCurrentSession().saveOrUpdate(formSchema);
        return formSchema;
	}

	/**
	 * @see FacilityDataDAO#getFacilityDataFormSchema(Integer)
	 */
	public FacilityDataFormSchema getFacilityDataFormSchema(Integer id) {
		return (FacilityDataFormSchema) sessionFactory.getCurrentSession().get(FacilityDataFormSchema.class, id);
	}

	/**
	 * @see FacilityDataDAO#getFacilityDataFormSchemaByUUID(String)
	 */
	public FacilityDataFormSchema getFacilityDataFormSchemaByUUID(String uuid) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataFormSchema.class);
        return (FacilityDataFormSchema) c.add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}

	/**
	 * @see FacilityDataDAO#getAllFacilityDataFormSchemas()
	 */
	@SuppressWarnings("unchecked")
	public List<FacilityDataFormSchema> getAllFacilityDataFormSchemas() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataFormSchema.class);
        return c.addOrder(Order.asc("name")).list();
	}

	/**
	 * @see FacilityDataDAO#deleteFacilityDataFormSchema(FacilityDataFormSchema)
	 */
	public void deleteFacilityDataFormSchema(FacilityDataFormSchema formSchema) {
		sessionFactory.getCurrentSession().delete(formSchema);
	}

	/**
	 * @see FacilityDataDAO#saveQuestionType(FacilityDataQuestionType)
	 */
	public FacilityDataQuestionType saveQuestionType(FacilityDataQuestionType questionType) {
		sessionFactory.getCurrentSession().saveOrUpdate(questionType);
		return questionType;
	}

	/**
	 * @see FacilityDataDAO#getQuestionType(java.lang.Integer)
	 */
	public FacilityDataQuestionType getQuestionType(Integer id) {
		return (FacilityDataQuestionType) sessionFactory.getCurrentSession().get(FacilityDataQuestionType.class, id);
	}

	/**
	 * @see FacilityDataDAO#getQuestionTypeByUUID(String)
	 */
	public FacilityDataQuestionType getQuestionTypeByUUID(String uuid) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataQuestionType.class);
        return (FacilityDataQuestionType) c.add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}

	/**
	 * @see FacilityDataDAO#getAllQuestionTypes()
	 */
	@SuppressWarnings("unchecked")
	public List<FacilityDataQuestionType> getAllQuestionTypes() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataQuestionType.class);
        return c.addOrder(Order.asc("name")).list();
	}

	/**
	 * @see FacilityDataDAO#deleteQuestionType(FacilityDataQuestionType)
	 */
	public void deleteQuestionType(FacilityDataQuestionType questionType) {
		sessionFactory.getCurrentSession().delete(questionType);
	}

	/**
	 * @see FacilityDataDAO#saveQuestion(FacilityDataQuestion)
	 */
	public FacilityDataQuestion saveQuestion(FacilityDataQuestion question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
        return question;
	}

	/**
	 * @see FacilityDataDAO#getQuestion(Integer)
	 */
	public FacilityDataQuestion getQuestion(Integer id) {
		return (FacilityDataQuestion) sessionFactory.getCurrentSession().get(FacilityDataQuestion.class, id);
	}

	/**
	 * @see FacilityDataDAO#getQuestionByUUID(String)
	 */
	public FacilityDataQuestion getQuestionByUUID(String uuid) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataQuestion.class);
        return (FacilityDataQuestion) c.add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}

	/**
	 * @see FacilityDataDAO#getAllQuestions()
	 */
	@SuppressWarnings("unchecked")
	public List<FacilityDataQuestion> getAllQuestions() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataQuestion.class);
        return c.addOrder(Order.asc("dateCreated")).list();
	}

	/**
	 * @see FacilityDataDAO#deleteQuestion(FacilityDataQuestion)
	 */
	public void deleteQuestion(FacilityDataQuestion question) {
		sessionFactory.getCurrentSession().delete(question);
	}

	/**
	 * @see FacilityDataDAO#saveFacilityDataValue(FacilityDataValue)
	 */
	public FacilityDataValue saveFacilityDataValue(FacilityDataValue value) {
		sessionFactory.getCurrentSession().saveOrUpdate(value);
        return value;
	}

	/**
	 * @see FacilityDataDAO#getFacilityDataValue(Integer)
	 */
	public FacilityDataValue getFacilityDataValue(Integer id) {
		return (FacilityDataValue) sessionFactory.getCurrentSession().get(FacilityDataValue.class, id);
	}

	/**
	 * @see FacilityDataDAO#getFacilityDataValues(FacilityDataFormSchema, Date, Date, Location)
	 */
	@SuppressWarnings("unchecked")
	public List<FacilityDataValue> getFacilityDataValues(FacilityDataFormSchema schema, Date startDate, Date endDate, Location location) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(FacilityDataValue.class);
		c.add(Restrictions.eq("question.section.schema", schema));
		c.add(Restrictions.eq("startDate", startDate));
		c.add(Restrictions.eq("endDate", endDate));
		c.add(Restrictions.eq("location", location));
		return c.list();
	}

	/**
	 * @see FacilityDataDAO#deleteFacilityDataValue(FacilityDataValue)
	 */
	public void deleteFacilityDataValue(FacilityDataValue value) {
		sessionFactory.getCurrentSession().delete(value);
	}
    
    //***** PROPERTY ACCESS *****
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}