package com.notification.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.notification.demo.model.NotificationTemplateModel;

@Repository
public interface INotificationTemplateRepository extends JpaRepository<NotificationTemplateModel, Integer> {

}
