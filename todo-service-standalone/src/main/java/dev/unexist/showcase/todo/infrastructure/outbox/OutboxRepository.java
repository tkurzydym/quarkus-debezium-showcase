/**
 * @package Quarkus-Outbox-Showcase
 *
 * @file Outbox repository interface
 * @copyright 2020-2021 Christoph Kappel <christoph@unexist.dev>
 * @version $Id$
 *
 * This program can be distributed under the terms of the GNU GPLv3.
 * See the file LICENSE for details.
 **/

package dev.unexist.showcase.todo.infrastructure.outbox;

public interface OutboxRepository {

    /**
     * Add {@link OutboxEntity} entry to list
     *
     * @param entity
     *          {@link OutboxEntity} entry to add
     * @return
     *          Either {@code true} on success; otherwise {@code false}
     **/

    boolean add(OutboxEntity entity);
}