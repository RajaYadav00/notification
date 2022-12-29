package com.indusnet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationTemplateRepository
		extends JpaRepository<com.indusnet.demo.model.NotificationTemplate, Integer> {

}
