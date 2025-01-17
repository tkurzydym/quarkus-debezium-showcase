/**
 * @package Quarkus-Outbox-Showcase
 *
 * @file Outbox entity
 * @copyright 2020-2021 Christoph Kappel <christoph@unexist.dev>
 * @version $Id$
 *
 * This program can be distributed under the terms of the GNU GPLv3.
 * See the file LICENSE for details.
 **/

package dev.unexist.showcase.todo.infrastructure.outbox;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "outbox_standalone")
public class OutboxEntity {

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "aggregateId")
    private Integer aggregateId;

    @Column(name = "eventType")
    private String eventType;

    @Column(name = "payload")
    private String payload;

    @Column(name = "createdOn")
    private Date createdOn;

    protected OutboxEntity() {
    }

    public OutboxEntity(UUID uuid, Integer aggregateId, String eventType, String payload) {
        this.uuid = requireNonNull(uuid);
        this.aggregateId = requireNonNull(aggregateId);
        this.eventType = requireNonNull(eventType);
        this.payload = requireNonNull(payload);
    }
}