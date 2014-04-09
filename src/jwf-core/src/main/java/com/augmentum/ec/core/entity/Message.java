/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 27, 2014
 */
package com.augmentum.ec.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Message.
 */
@Entity
@Table(name = "message", catalog = "ec_core")
public final class Message implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8271957409866834054L;

    /** The message id. */
    private Long messageId;

    /** The message type id. */
    private Integer messageTypeId;

    /** The user id. */
    private Long userId;

    /** The from user id. */
    private Long fromUserId;

    /** The subject. */
    private String subject;

    /** The content. */
    private String content;

    /** The is read. */
    private boolean isRead;

    /** The is trashed. */
    private boolean isTrashed;

    /** The is deleted. */
    private boolean isDeleted;

    /** The created. */
    private Date created;

    /** The read. */
    private Date read;

    /** The trashed. */
    private Date trashed;

    /** The deleted. */
    private Date deleted;

    /**
     * Instantiates a new message.
     */
    public Message() {
    }

    /**
     * Gets the message id.
     *
     * @return the message id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "message_id", unique = true, nullable = false)
    public Long getMessageId() {
        return this.messageId;
    }

    /**
     * Sets the message id.
     *
     * @param messageId the new message id
     */
    public void setMessageId(final Long messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets the message type id.
     *
     * @return the message type id
     */
    @Column(name = "message_type_id", nullable = false)
    public Integer getMessageTypeId() {
        return this.messageTypeId;
    }

    /**
     * Sets the message type id.
     *
     * @param messageTypeId the new message type id
     */
    public void setMessageTypeId(final Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the from user id.
     *
     * @return the from user id
     */
    @Column(name = "from_user_id", nullable = false)
    public Long getFromUserId() {
        return this.fromUserId;
    }

    /**
     * Sets the from user id.
     *
     * @param fromUserId the new from user id
     */
    public void setFromUserId(final Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    @Column(name = "subject", nullable = false)
    public String getSubject() {
        return this.subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject the new subject
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    @Column(name = "content", length = 65535)
    public String getContent() {
        return this.content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(final String content) {
        this.content = content;
    }

    /**
     * Checks if is checks if is read.
     *
     * @return true, if is checks if is read
     */
    @Column(name = "is_read", nullable = false)
    public boolean isIsRead() {
        return this.isRead;
    }

    /**
     * Sets the checks if is read.
     *
     * @param isRead the new checks if is read
     */
    public void setIsRead(final boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * Checks if is checks if is trashed.
     *
     * @return true, if is checks if is trashed
     */
    @Column(name = "is_trashed", nullable = false)
    public boolean isIsTrashed() {
        return this.isTrashed;
    }

    /**
     * Sets the checks if is trashed.
     *
     * @param isTrashed the new checks if is trashed
     */
    public void setIsTrashed(final boolean isTrashed) {
        this.isTrashed = isTrashed;
    }

    /**
     * Checks if is checks if is deleted.
     *
     * @return true, if is checks if is deleted
     */
    @Column(name = "is_deleted", nullable = false)
    public boolean isIsDeleted() {
        return this.isDeleted;
    }

    /**
     * Sets the checks if is deleted.
     *
     * @param isDeleted the new checks if is deleted
     */
    public void setIsDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * Gets the created.
     *
     * @return the created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, length = 19)
    public Date getCreated() {
        return this.created;
    }

    /**
     * Sets the created.
     *
     * @param created the new created
     */
    public void setCreated(final Date created) {
        this.created = created;
    }

    /**
     * Gets the read.
     *
     * @return the read
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "read", length = 19)
    public Date getRead() {
        return this.read;
    }

    /**
     * Sets the read.
     *
     * @param read the new read
     */
    public void setRead(final Date read) {
        this.read = read;
    }

    /**
     * Gets the trashed.
     *
     * @return the trashed
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "trashed", length = 19)
    public Date getTrashed() {
        return this.trashed;
    }

    /**
     * Sets the trashed.
     *
     * @param trashed the new trashed
     */
    public void setTrashed(final Date trashed) {
        this.trashed = trashed;
    }

    /**
     * Gets the deleted.
     *
     * @return the deleted
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted", length = 19)
    public Date getDeleted() {
        return this.deleted;
    }

    /**
     * Sets the deleted.
     *
     * @param deleted the new deleted
     */
    public void setDeleted(final Date deleted) {
        this.deleted = deleted;
    }

}
