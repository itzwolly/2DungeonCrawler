package com.wolly.dungeoncrawler;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.wolly.dungeoncrawler.core.Vector2;

public class Utils {
	public static Set<BeanDefinition> GetClassesByAnnotation(String pBasePackage, Class<? extends Annotation> pClass, boolean pUseDefaultFilters) {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(pUseDefaultFilters);
		scanner.addIncludeFilter(new AnnotationTypeFilter(pClass));
		return scanner.findCandidateComponents(pBasePackage);
	}
	
	public static String GetPackagePathFromFullPackagePath(String pInput) {
		if (IsPackagePath(pInput)) {
			int endIndex = pInput.lastIndexOf(".") + 1;
		    if (endIndex != -1) {
		        return pInput.substring(0, endIndex - 1);
		    }
		}
	    return "";
	}
	
	public static String GetClassNameFromFullPackagePath(String pInput) {
		if (IsPackagePath(pInput)) {
			int endIndex = pInput.lastIndexOf(".") + 1;
		    if (endIndex != -1) {
		        return pInput.substring(endIndex, pInput.length());
		    }
		}
	    return "";
	}
	
	public static boolean IsPackagePath(String pInput) {
		Pattern p = Pattern.compile("([a-zA_Z_][\\.\\w]*)");
		Matcher m = p.matcher(pInput);
		return m.find();
	}
}
