# $Id: Makefile,v 1.2 2011/09/25 14:49:28 david Exp $

JAVADIR=/Users/Armstrong/Bank_
JARNAME=po-bank-textui

all:
	(cd src; javac -encoding UTF-8 -cp $(JAVADIR)/po-uilib.jar:$(JAVADIR)/po-bank-support.jar:$(JAVADIR)/po-bank-core.jar `find . -name \*.java`)
	(cd src; jar cvf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java` )

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`
