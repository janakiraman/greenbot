package greenbot.provider.converter;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import greenbot.rule.model.Tag;

@Component
public class StringToTagConverter implements Converter<String, Tag>{
	
	@Override
	public Tag convert(String source) {
		String[] tokens = source.split("=");
		if(tokens.length!= 2){
			throw new RuntimeException("Invalid tag sting " + source);
		}
		
		return Tag.builder().key(tokens[0]).value(tokens[1]).build();
	}
}