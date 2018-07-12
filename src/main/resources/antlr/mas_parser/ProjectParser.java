package main.resources.antlr.mas_parser;

import main.java.uncertain_agentspeak.mas.MASProject;
import main.resources.antlr.MASProjectLexer;
import main.resources.antlr.MASProjectParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;

public class ProjectParser {

        public MASProject parseMASProject(FileInputStream input) throws Exception {
            ANTLRInputStream inputStream = new ANTLRInputStream(input);
            MASProjectLexer masProjectLexer = new MASProjectLexer(inputStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(masProjectLexer);
            MASProjectParser masProjectParser = new MASProjectParser(commonTokenStream);

            MASProjectVisitor masProjectVisitor = new MASProjectVisitor();

            MASProjectParser.Mas_projectContext mas_projectContext = masProjectParser.mas_project();
            return (MASProject) masProjectVisitor.visitMas_project(mas_projectContext);
        }

}
