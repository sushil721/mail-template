package com.paxcel.mail.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@SuppressWarnings("deprecation")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainModel {
	
	private String type;
	private String title;
	private String domainObjectName;
	private String name;
	private String componentId;
	private String cssClasses;
	
	
	
	private Map<String,Integer> properties = new HashMap<>();
	
	private String altText; 
	private String text;
	private String src;
	private String width;
	
	private String binding;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	private Boolean readonly=false;
	private String label;//"  : "Account Number",
	private String messageKey;//": "Copyright (c) Paymentus Co. 2019",
	private String length;
	private String scale;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	private Boolean disabled=false;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	private Boolean required=true;
	private String format;//": "SHORT_FORMAT",
	private String parentTrigger;//": "",
	private String minLength;//": 0,
	private String maxLength;//": 32,
	
	private String target;
	private String url;
	
	
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
	private List<DomainModel> children = new ArrayList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public Map<String, Integer> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Integer> properties) {
		this.properties = properties;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public List<DomainModel> getChildren() {
		return children;
	}

	public void setChildren(List<DomainModel> children) {
		this.children = children;
	}

	public String getDomainObjectName() {
		return domainObjectName;
	}

	public void setDomainObjectName(String domainObjectName) {
		this.domainObjectName = domainObjectName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getCssClasses() {
		return cssClasses;
	}

	public void setCssClasses(String cssClasses) {
		this.cssClasses = cssClasses;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getParentTrigger() {
		return parentTrigger;
	}

	public void setParentTrigger(String parentTrigger) {
		this.parentTrigger = parentTrigger;
	}

	public String getMinLength() {
		return minLength;
	}

	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}

	public String getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	

}