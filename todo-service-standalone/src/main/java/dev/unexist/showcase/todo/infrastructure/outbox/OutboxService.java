/**
 * @package Quarkus-Outbox-Showcase
 *
 * @file Outbox domain service
 * @copyright 2020-2021 Christoph Kappel <christoph@unexist.dev>
 * @version $Id$
 *
 * This program can be distributed under the terms of the GNU GPLv3.
 * See the file LICENSE for details.
 **/

package dev.unexist.showcase.todo.infrastructure.outbox;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.UUID;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;

@ApplicationScoped
public class OutboxService {

    @Inject
    OutboxRepository outboxRepository;

    @Transactional(REQUIRES_NEW)
    public void handleOutboxEvent(@Observes(during = TransactionPhase.AFTER_SUCCESS) OutboxEvent event) {
        UUID uuid = UUID.randomUUID();

        OutboxEntity entity = new OutboxEntity(uuid,
            event.getAggregateId(),
            event.getEventType(),
            event.getPayload());

        outboxRepository.add(entity);
    }
}
