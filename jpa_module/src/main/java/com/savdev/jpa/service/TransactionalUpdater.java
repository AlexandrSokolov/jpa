package com.savdev.jpa.service;

/**
 *
 */
public interface TransactionalUpdater<ER, EW extends ER> {
     ER applyUpdate(EW writbleEntity);
}
