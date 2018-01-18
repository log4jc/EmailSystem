package com.jwebcoder.emailsystem.dao;

import com.jwebcoder.emailsystem.entity.HtmlEmail;
import org.springframework.stereotype.Repository;

@Repository
public interface HtmlEmailDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    int insert(HtmlEmail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    int insertSelective(HtmlEmail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    HtmlEmail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(HtmlEmail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(HtmlEmail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HTML_EMAIL
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(HtmlEmail record);
}