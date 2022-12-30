package com.notification.demo.service;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.notification.demo.model.NotificationTemplate;
import com.notification.demo.model.common.SuccessResponseModel;
/**
 * This interface is used for Notification template
 * save
 * update
 * fetch list
 * delete
 * @author Raja Ram Yadav
 *
 */
@Validated
public interface INotificationTemplateService {
	/**
	 * This method is used to save the notification Template in database
	 * 
	 * @param notificationTemp This holds the details of notification template
	 * @return this method return the success response if data is saved successfully
	 */
	public SuccessResponseModel saveNotificationTemplate(@Valid NotificationTemplate notificationTemp);

	/**
	 * This method us used to fetch the list of templates
	 * @return it returns success response with list of templates
	 */
	public SuccessResponseModel getAllNotificationTemplateFromDatabase();
	/**
	 * This method is used to replace the template with new template by using  id
	 * 
	 * @param id this is Id of template whose details we want to update
	 * @param notificationTemplate this is the details to be updated
	 * @return it return the success response with message that template is updated
	 */
	public SuccessResponseModel replaceNotificationTemplate(Integer id,NotificationTemplate notificationTemplate);
	public SuccessResponseModel deleteNotificationTemplate(Integer id);

}
