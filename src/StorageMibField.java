

public abstract class StorageMibField {

    public enum BeaconType {
        NOBEACON,
        OWNEDASSOCIATION,
        OWNEDEXTENSION,
        CONTAINEDGENERICTRACE,
        OWNEDCLASS,
        CONTAINEDPROPERTY,
        OWNEDMEMBER,
        OWNEDCARD,
        OWNEDDATATYPE,
        OWNEDPROPERTYVALUE,
        DOMAINVALUE,
        OWNEDLITERAL,
        VARIABILITYFEATURES,
        OWNEDEXCHANGEITEM,
        OWNEDELEMENT,
        OWNEDINTERFACES,
        OWNEDEXCHANGEITEMALLOCATIONS,
        OWNEDINTERFACEPKGS,
        OWNEDMESSAGES,
        OWNEDGENERALIZATIONS,
        OWNEDFEATURES,
        OWNEDTRACES,
        OWNEDINFORMATIONREALIZATIONS,
        OWNEDDEFAULTVALUE,
        OWNEDUNITS,
        OWNEDMINVALUE,
        OWNEDMAXVALUE,
        OWNEDMINLENGTH,
        OWNEDMAXLENGTH,
        OWNEDINSTANCEROLES,
        OWNEDINTERACTIONFRAGMENTS,
        OWNEDTIMELAPSES,
        OWNEDEVENTS,
        OWNEDSCENARIOS,
        OWNEDSYSTEMCAPABILITYINVOLVMENT,
        OWNEDSPECIFICATION,
        OWNEDCONSTRAINTS,
        OWNEDACTORCAPABILITYINVOLVMENTS,
        OWNEDCAPABILITIES,
        OWNEDCAPABILITYPKG,
        OWNEDFUNCTIONALCHAININVOLVMENTS,
        OWNEDFUNCTIONALCHAINREALIZATIONS,
        OWNEDPHYSICALCOMPONENTS,
        OWNEDPHYSICALCOMPONENTPKG,
        OWNEDLOGICALARCHITECTUREREALIZATIONS,
        OWNEDFUNCTIONS,
        OWNEDFUNCTIONALCHAINS,
        OWNEDPORTREALIZATIONS,
        OWNEDFUNCTIONREALIZATIONS,
        OUTPUTS,
        INPUTS,
        OWNEDFUNCTIONALEXCHANGEREALIZATIONS,
        OWNEDFUNCTIONALEXCHANGES,
        OWNEDPHYSICALFUNCTIONS,
        OWNEDFUNCTIONALPKG,
        OWNEDCAPABILITYREALIZATIONINVOLVMENTS,
        OWNEDCAPABILITYREALIZATIONS,
        OWNEDABSTRACTCAPABILITYPKG,
        OWNEDINTERFACEPKG,
        OWNEDDATAPKG,
        OWNEDPARTS,
        OWNEDPHYSICALLINKS,
        OWNEDCOMPONENTEXCHANGES,
        OWNEDDEPLOYMENTLINKS,
        OWNEDCOMPONENTREALIZATIONS,
        OWNEDFUNCTIONALALLOCATIONS,
        OWNEDPORTALLOCATIONS,
        OWNEDCOMPONENTPORTSALLOCATIONS
    }

    BeaconType typeOfbeacon;
    String identifier;


    /* Used to know the Id of a concrete class which extends StorageMibId */
    /* Used to build the protobuf files                                   */
    public abstract String GetId();

    /**
     * Comment transformation to be accepted by protofiles file compilers.
     * <p>
     * Authorized characters in mib files
     * -----------------------------------
     * Any found characters not in the list replaced with @ASCIICODE
     * except:
     * �,�,�,� with e
     * � with a
     * � with i
     * � with c
     * Note: " (QUOTATION MARK)not taken in account! Description field separator
     * Note: Suppression of XML beacons: <p>, </p>, <li>, </li>, <ul>, </ul>, <br />
     * <p>
     * List
     * -----
     * A � Z (LATIN CAPITAL LETTER A to LATIN CAPITAL LETTER Z)
     * a � z (LATIN SMALL LETTER A to LATIN SMALL LETTER Z)
     * 0 � 9 (DIGIT ZERO to DIGIT 9)
     * ! (EXCLAMATION MARK)
     * & (AMPERSAND)
     * ' (APOSTROPHE)
     * ( (LEFT PARENTHESIS)
     * ) (RIGHT PARENTHESIS)
     * * (ASTERISK)
     * , (COMMA)
     * - (HYPHEN-MINUS)
     * . (FULL STOP)
     * / (SOLIDUS)
     * : (COLON)
     * ; (SEMICOLON)
     * < (LESS-THAN SIGN)
     * = (EQUALS SIGN)
     * > (GREATER-THAN SIGN)
     *
     * @param Comment
     * @return
     * @ (COMMERCIAL AT)
     * [ (LEFT SQUARE BRACKET)
     * ] (RIGHT SQUARE BRACKET)
     * ^ (CIRCUMFLEX ACCENT)
     * _ (LOW LINE)
     * { (LEFT CURLY BRACKET)
     * | (VERTICAL LINE)
     * } (RIGHT CURLY BRACKET)
     * <p>
     * Accepted separators:
     * <p>
     * HORIZONTAL TABULATION (code ASCII 9)
     * LINE FEED (code ASCII 10)
     * VERTICAL TABULATION (code ASCII 11)
     * FORM FEED (code ASCII 12)
     * CARRIAGE RETURN (code ASCII 13)
     * SPACE (code ASCII 32)
     */
    public static String ChangeProtobufComment(String Comment) {
        String ModifiedComment = Comment;
        //suppress beacons
        ModifiedComment = ModifiedComment.replaceAll("<p>", "");
        ModifiedComment = ModifiedComment.replaceAll("</p>", "");
        ModifiedComment = ModifiedComment.replaceAll("<li>", "");
        ModifiedComment = ModifiedComment.replaceAll("</li>", "");
        ModifiedComment = ModifiedComment.replaceAll("<ul>", "");
        ModifiedComment = ModifiedComment.replaceAll("</ul>", "");
        ModifiedComment = ModifiedComment.replaceAll("<br />", "");
        ModifiedComment = ModifiedComment.replaceAll("&nbsp;", " ");
        ModifiedComment = ModifiedComment.replaceAll("&amp;", "");

        boolean nochange = false;
        boolean changeDone = false;
        for (int i = 0; i < Comment.length(); i++) {
            char a = Comment.charAt(i);
            nochange = false;
            if ((((int) a) >= ((int) 'a')) && (((int) a) <= ((int) 'z'))) nochange = true;
            if ((((int) a) >= ((int) 'A')) && (((int) a) <= ((int) 'Z'))) nochange = true;
            if ((((int) a) >= ((int) '0')) && (((int) a) <= ((int) '9'))) nochange = true;

            if ((a == '!') ||
                    (a == '\"') ||
                    (a == '&') || /*(AMPERSAND)*/
                    (a == '\'') || /*(APOSTROPHE)*/
                    (a == '(') || /*(LEFT PARENTHESIS)*/
                    (a == ')') || /*(RIGHT PARENTHESIS)*/
                    (a == '*') || /*(ASTERISK)*/
                    (a == ',') || /*(COMMA)*/
                    (a == '-') || /*(HYPHEN-MINUS)*/
                    (a == '.') || /*(FULL STOP)*/
                    (a == '/') || /*(SOLIDUS)*/
                    (a == ':') || /*(COLON)*/
                    (a == ';') || /*(SEMICOLON)*/
                    (a == '<') || /*(LESS-THAN SIGN)*/
                    (a == '=') || /*(EQUALS SIGN)*/
                    (a == '>') || /*(GREATER-THAN SIGN)*/
                    (a == '@') || /*(COMMERCIAL AT)*/
                    (a == '[') || /*(LEFT SQUARE BRACKET)*/
                    (a == ']') || /*(RIGHT SQUARE BRACKET)*/
                    (a == '^') || /*(CIRCUMFLEX ACCENT)*/
                    (a == '_') || /*(LOW LINE)*/
                    (a == '{') || /*(LEFT CURLY BRACKET)*/
                    (a == '|') || /*(VERTICAL LINE)*/
                    (a == '}') || /*(RIGHT CURLY BRACKET)*/
                    (a == '+')) /* (PLUS)*/ nochange = true;

            if (((int) a == 9) ||/*HORIZONTAL TABULATION (code ASCII 9)*/
                    ((int) a == 10) ||         /*LINE FEED (code ASCII 10)*/
                    ((int) a == 11) ||/*VERTICAL TABULATION (code ASCII 11)*/
                    ((int) a == 12) ||/*FORM FEED (code ASCII 12)*/
                    ((int) a == 13) ||/*CARRIAGE RETURN (code ASCII 13)*/
                    ((int) a == 32))/*SPACE (code ASCII 32)*/ nochange = true;
/*		
		if(nochange==false){
			if((a=='�')||(a=='�')||(a=='�')||(a=='�')) {ModifiedComment = ModifiedComment.replace(a, 'e'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'a'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'i'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'c'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'u'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'i'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, '\''); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'e'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, '>'); changeDone = true;}
			if(a=='�') {ModifiedComment = ModifiedComment.replace(a, 'u'); changeDone = true;}
//			if(changeDone == false) {String val = '@'+(String.valueOf((int)a)); 
			ModifiedComment = ModifiedComment.replaceAll((String)""+a, val);changeDone = true; i = i+1;}
		}
		*/
        }

        return ModifiedComment;
    }

}
