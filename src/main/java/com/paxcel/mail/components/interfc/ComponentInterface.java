package com.paxcel.mail.components.interfc;

import java.io.IOException;
import java.io.Writer;

import com.paxcel.mail.model.DomainModel;

public interface ComponentInterface {

	Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException;
}
