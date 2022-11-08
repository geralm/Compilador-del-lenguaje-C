// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/main/jflex/simpleCup.flex


package CompiladorC;

import java_cup.runtime.*;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class LexerCupAnalyzer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 1
  };

  /**
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  2,  0,  0,  3,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     4,  5,  6,  7,  0,  5,  8,  9, 10, 10, 11, 12, 10, 13, 14, 15, 
    16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 10, 10, 19, 20, 21, 10, 
     0, 22, 22, 22, 23, 24, 23, 25, 25, 25, 25, 25, 26, 25, 25, 25, 
    25, 25, 25, 25, 25, 25, 25, 25, 27, 25, 25, 10,  0, 10,  5, 25, 
     0, 28, 29, 30, 31, 32, 33, 34, 35, 36, 25, 37, 38, 39, 40, 41, 
    42, 25, 43, 44, 45, 46, 47, 48, 49, 50, 51, 10, 52, 10, 10,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\1\1\4\1\1"+
    "\5\4\2\5\2\4\20\6\1\4\1\1\1\0\1\5"+
    "\1\0\1\5\1\0\1\7\1\5\1\0\1\10\1\5"+
    "\2\10\6\6\1\11\4\6\1\11\14\6\5\0\2\5"+
    "\31\6\2\0\1\5\1\7\16\6\2\0\7\6\2\0"+
    "\2\6\13\0\1\6\2\0\2\6\3\0\1\6\5\0"+
    "\2\6\2\0\3\6";

  private static int [] zzUnpackAction() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\237\0\324\0\u0109\0\u013e\0\u0173"+
    "\0\u01a8\0\152\0\u01dd\0\u0212\0\u0247\0\u027c\0\u02b1\0\u02e6"+
    "\0\u031b\0\u0350\0\u0385\0\u03ba\0\u03ef\0\u0424\0\u0459\0\u048e"+
    "\0\u04c3\0\u04f8\0\u052d\0\u0562\0\u0597\0\u05cc\0\u0601\0\u0636"+
    "\0\u066b\0\u06a0\0\u06d5\0\u070a\0\u013e\0\152\0\u073f\0\u0774"+
    "\0\u07a9\0\u07de\0\u0813\0\u0848\0\u087d\0\u087d\0\u08b2\0\u08e7"+
    "\0\u091c\0\u0951\0\u0986\0\u09bb\0\u09f0\0\u0a25\0\u0a5a\0\u0a8f"+
    "\0\u0ac4\0\u0af9\0\u0b2e\0\u0385\0\u0b63\0\u0b98\0\u0bcd\0\u0c02"+
    "\0\u0c37\0\u0c6c\0\u0ca1\0\u0cd6\0\u0d0b\0\u0d40\0\u0d75\0\u0daa"+
    "\0\u0ddf\0\u0e14\0\u0e49\0\u0e7e\0\u0eb3\0\u0ee8\0\u0f1d\0\u0f52"+
    "\0\u0f87\0\u0fbc\0\u0ff1\0\u1026\0\u105b\0\u1090\0\u10c5\0\u10fa"+
    "\0\u112f\0\u1164\0\u1199\0\u11ce\0\u1203\0\u1238\0\u126d\0\u12a2"+
    "\0\u12d7\0\u130c\0\u1341\0\u1376\0\u13ab\0\u13e0\0\u1415\0\u144a"+
    "\0\u147f\0\u14b4\0\u14e9\0\152\0\u151e\0\u1553\0\u1588\0\u15bd"+
    "\0\u15f2\0\u1627\0\u165c\0\u1691\0\u16c6\0\u16fb\0\u1730\0\u1765"+
    "\0\u179a\0\u17cf\0\u1804\0\u1839\0\u186e\0\u18a3\0\u18d8\0\u190d"+
    "\0\u1942\0\u1977\0\u19ac\0\u19e1\0\u1a16\0\u1a4b\0\u1a80\0\u1ab5"+
    "\0\u1aea\0\u1b1f\0\u1b54\0\u1b89\0\u1bbe\0\u1bf3\0\u1c28\0\u1c5d"+
    "\0\u1c92\0\u1cc7\0\u1c5d\0\u1cfc\0\u1d31\0\u1d66\0\u1d9b\0\u1dd0"+
    "\0\u1e05\0\u1e3a\0\u1e6f\0\u1ea4\0\u1ed9\0\u1f0e\0\u1f43\0\u1f78"+
    "\0\u1fad\0\u1fe2\0\u2017\0\u204c\0\u2081\0\u20b6\0\152";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\2\4\1\6\1\7\1\3\1\10"+
    "\1\11\1\12\1\6\1\13\1\14\1\15\1\16\1\17"+
    "\2\20\1\21\1\6\1\22\6\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\23\1\33\1\23\1\34"+
    "\4\23\1\35\1\36\1\37\1\40\1\41\1\42\3\23"+
    "\1\43\1\3\1\4\1\5\2\4\1\6\1\7\1\44"+
    "\1\10\1\11\1\12\1\6\1\13\1\14\1\15\1\16"+
    "\1\17\2\20\1\21\1\6\1\22\6\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\23\1\33\1\23"+
    "\1\34\4\23\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\3\23\1\43\66\0\1\4\1\0\2\4\62\0\1\5"+
    "\106\0\1\12\40\0\6\45\1\46\56\45\10\0\1\12"+
    "\13\0\1\12\40\0\11\47\1\0\53\47\14\0\1\12"+
    "\7\0\1\12\55\0\1\12\6\0\2\12\57\0\3\50"+
    "\55\0\1\51\3\0\1\52\4\0\1\12\56\0\1\50"+
    "\1\0\2\53\1\54\3\0\1\55\1\56\1\57\1\55"+
    "\1\56\1\60\3\55\1\56\1\57\1\56\17\55\1\60"+
    "\2\55\17\0\1\50\1\0\3\20\3\0\1\55\1\56"+
    "\1\57\1\55\1\56\4\55\1\56\1\57\1\56\22\55"+
    "\24\0\1\6\1\12\64\0\1\12\1\6\57\0\3\23"+
    "\3\0\36\23\21\0\3\23\3\0\30\23\1\61\5\23"+
    "\21\0\3\23\3\0\25\23\1\62\10\23\21\0\3\23"+
    "\3\0\6\23\1\63\6\23\1\64\5\23\1\65\12\23"+
    "\21\0\3\23\3\0\12\23\1\66\10\23\1\67\12\23"+
    "\21\0\3\23\3\0\20\23\1\63\1\23\1\70\10\23"+
    "\1\71\2\23\21\0\3\23\3\0\20\23\1\72\2\23"+
    "\1\73\12\23\21\0\3\23\3\0\23\23\1\61\12\23"+
    "\21\0\3\23\3\0\13\23\1\74\6\23\1\75\13\23"+
    "\21\0\3\23\3\0\23\23\1\76\12\23\21\0\3\23"+
    "\3\0\12\23\1\77\23\23\21\0\3\23\3\0\15\23"+
    "\1\100\1\101\10\23\1\102\2\23\1\103\3\23\21\0"+
    "\3\23\3\0\34\23\1\104\1\23\21\0\3\23\3\0"+
    "\22\23\1\105\13\23\21\0\3\23\3\0\23\23\1\106"+
    "\12\23\21\0\3\23\3\0\15\23\1\107\7\23\1\110"+
    "\10\23\25\0\1\12\37\0\1\12\37\0\1\111\4\0"+
    "\1\112\31\0\1\46\73\0\3\50\4\0\1\46\1\113"+
    "\6\0\1\46\1\113\1\46\23\0\13\51\1\114\51\51"+
    "\2\52\2\0\61\52\16\0\1\50\1\0\2\53\1\54"+
    "\3\0\1\55\1\56\1\57\1\55\1\56\4\55\1\56"+
    "\1\57\1\56\22\55\17\0\1\50\1\0\3\54\3\0"+
    "\1\55\1\56\1\57\6\55\1\56\1\57\1\56\22\55"+
    "\21\0\3\55\3\0\36\55\15\0\2\115\2\0\3\116"+
    "\3\0\36\55\21\0\3\117\3\0\3\117\3\55\6\117"+
    "\22\55\21\0\3\23\3\0\27\23\1\120\6\23\21\0"+
    "\3\23\3\0\12\23\1\121\23\23\21\0\3\23\3\0"+
    "\26\23\1\122\7\23\21\0\3\23\3\0\6\23\1\73"+
    "\27\23\21\0\3\23\3\0\22\23\1\123\13\23\21\0"+
    "\3\23\3\0\13\23\1\124\22\23\21\0\3\23\3\0"+
    "\30\23\1\125\5\23\21\0\3\23\3\0\30\23\1\126"+
    "\5\23\21\0\3\23\3\0\27\23\1\127\6\23\21\0"+
    "\3\23\3\0\23\23\1\130\12\23\21\0\3\23\3\0"+
    "\25\23\1\74\10\23\21\0\3\23\3\0\27\23\1\74"+
    "\6\23\21\0\3\23\3\0\22\23\1\131\13\23\21\0"+
    "\3\23\3\0\6\23\1\132\5\23\1\133\12\23\1\134"+
    "\6\23\21\0\3\23\3\0\23\23\1\135\12\23\21\0"+
    "\3\23\3\0\14\23\1\136\20\23\1\137\21\0\3\23"+
    "\3\0\6\23\1\140\16\23\1\141\10\23\21\0\3\23"+
    "\3\0\16\23\1\142\17\23\21\0\3\23\3\0\24\23"+
    "\1\143\11\23\21\0\3\23\3\0\16\23\1\144\7\23"+
    "\1\145\7\23\21\0\3\23\3\0\16\23\1\132\1\23"+
    "\1\146\15\23\21\0\3\23\3\0\16\23\1\147\17\23"+
    "\21\0\3\23\3\0\16\23\1\150\17\23\41\0\1\151"+
    "\74\0\1\152\30\0\2\115\2\0\3\153\42\0\13\51"+
    "\1\114\3\51\1\154\45\51\20\0\3\153\62\0\3\116"+
    "\3\0\1\55\1\56\7\55\1\56\1\55\1\56\22\55"+
    "\21\0\3\117\3\0\3\117\1\55\1\56\1\55\6\117"+
    "\22\55\21\0\3\23\3\0\23\23\1\74\12\23\21\0"+
    "\3\23\3\0\6\23\1\155\27\23\21\0\3\23\3\0"+
    "\12\23\1\74\23\23\21\0\3\23\3\0\27\23\1\156"+
    "\6\23\21\0\3\23\3\0\6\23\1\157\27\23\21\0"+
    "\3\23\3\0\7\23\1\147\26\23\21\0\3\23\3\0"+
    "\21\23\1\74\14\23\21\0\3\23\3\0\12\23\1\160"+
    "\23\23\21\0\3\23\3\0\6\23\1\75\27\23\21\0"+
    "\3\23\3\0\14\23\1\74\21\23\21\0\3\23\3\0"+
    "\11\23\1\74\24\23\21\0\3\23\3\0\16\23\1\161"+
    "\17\23\21\0\3\23\3\0\30\23\1\160\5\23\21\0"+
    "\3\23\3\0\25\23\1\75\10\23\21\0\3\23\3\0"+
    "\22\23\1\162\13\23\21\0\3\23\3\0\12\23\1\163"+
    "\23\23\21\0\3\23\3\0\27\23\1\164\6\23\21\0"+
    "\3\23\3\0\30\23\1\165\5\23\21\0\3\23\3\0"+
    "\27\23\1\166\6\23\21\0\3\23\3\0\12\23\1\167"+
    "\23\23\21\0\3\23\3\0\23\23\1\170\12\23\21\0"+
    "\3\23\3\0\16\23\1\171\17\23\21\0\3\23\3\0"+
    "\6\23\1\172\27\23\21\0\3\23\3\0\20\23\1\122"+
    "\15\23\21\0\3\23\3\0\27\23\1\122\6\23\42\0"+
    "\1\173\61\0\1\174\46\0\3\153\4\0\1\46\7\0"+
    "\1\46\1\0\1\46\43\0\3\23\3\0\17\23\1\74"+
    "\16\23\21\0\3\23\3\0\16\23\1\175\17\23\21\0"+
    "\3\23\3\0\30\23\1\176\5\23\21\0\3\23\3\0"+
    "\25\23\1\170\10\23\21\0\3\23\3\0\26\23\1\177"+
    "\7\23\21\0\3\23\3\0\12\23\1\132\23\23\21\0"+
    "\3\23\3\0\23\23\1\200\12\23\21\0\3\23\3\0"+
    "\16\23\1\201\17\23\21\0\3\23\3\0\10\23\1\75"+
    "\25\23\21\0\3\23\3\0\10\23\1\202\25\23\21\0"+
    "\3\23\3\0\11\23\1\203\24\23\21\0\3\23\3\0"+
    "\22\23\1\74\13\23\21\0\3\23\3\0\14\23\1\136"+
    "\21\23\21\0\3\23\3\0\27\23\1\107\6\23\45\0"+
    "\1\204\66\0\1\205\36\0\3\23\3\0\22\23\1\206"+
    "\13\23\21\0\3\23\3\0\20\23\1\75\15\23\21\0"+
    "\3\23\3\0\27\23\1\207\6\23\21\0\3\23\3\0"+
    "\13\23\1\74\22\23\21\0\3\23\3\0\10\23\1\74"+
    "\25\23\21\0\3\23\3\0\15\23\1\74\20\23\21\0"+
    "\3\23\3\0\12\23\1\200\23\23\51\0\1\210\72\0"+
    "\1\211\26\0\3\23\3\0\30\23\1\122\5\23\21\0"+
    "\3\23\3\0\12\23\1\73\23\23\41\0\1\212\63\0"+
    "\1\213\31\0\1\214\120\0\1\215\52\0\36\216\5\0"+
    "\1\217\64\0\1\220\13\0\3\216\3\0\36\216\7\0"+
    "\1\221\14\0\1\222\42\0\1\223\1\0\3\223\1\224"+
    "\1\0\1\223\1\225\6\223\1\226\2\227\3\223\36\0"+
    "\1\223\26\0\36\230\27\0\36\231\1\0\6\224\1\223"+
    "\56\224\11\232\1\0\53\232\1\0\1\223\1\0\3\223"+
    "\1\224\1\0\1\223\1\225\4\223\1\233\1\223\1\226"+
    "\2\227\3\223\1\0\1\223\1\234\1\0\1\223\1\235"+
    "\3\0\1\223\1\234\1\223\17\0\1\235\2\0\1\223"+
    "\1\0\1\223\1\0\3\223\1\224\1\0\1\223\1\225"+
    "\4\223\1\233\1\223\1\226\2\227\3\223\1\0\1\223"+
    "\1\234\1\0\1\223\4\0\1\223\1\234\1\223\22\0"+
    "\1\223\16\0\1\236\1\0\3\230\3\0\36\230\17\0"+
    "\1\237\1\0\3\231\3\0\36\231\12\0\1\223\54\0"+
    "\1\223\1\0\3\223\1\224\1\0\1\223\1\225\6\223"+
    "\1\226\2\227\3\223\1\0\1\223\1\234\6\0\1\223"+
    "\1\234\1\223\22\0\1\223\14\0\2\240\2\0\3\241"+
    "\62\0\3\242\3\0\3\242\3\0\6\242\66\0\1\243"+
    "\64\0\1\244\41\0\3\241\43\0\1\223\1\0\3\223"+
    "\1\224\1\0\1\223\1\225\6\223\1\226\2\227\3\223"+
    "\1\0\1\223\7\0\1\223\1\0\1\223\22\0\1\223"+
    "\1\0\1\223\1\0\3\223\1\224\1\0\1\223\1\225"+
    "\6\223\1\245\2\246\3\223\3\242\1\0\1\223\1\0"+
    "\6\242\22\0\1\223\6\0\1\247\103\0\1\247\40\0"+
    "\1\223\1\0\3\223\1\224\1\0\1\223\1\225\4\223"+
    "\1\233\1\223\1\245\2\246\3\223\3\242\1\0\1\223"+
    "\1\235\6\242\17\0\1\235\2\0\1\223\1\0\1\223"+
    "\1\0\3\223\1\224\1\0\1\223\1\225\4\223\1\233"+
    "\1\223\1\245\2\246\3\223\3\242\1\0\1\223\1\0"+
    "\6\242\22\0\1\223";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8427];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\6\1\1\11\32\1\1\0\1\11\1\0"+
    "\1\1\1\0\2\1\1\0\34\1\5\0\33\1\2\0"+
    "\1\1\1\11\16\1\2\0\7\1\2\0\2\1\13\0"+
    "\1\1\2\0\2\1\3\0\1\1\5\0\2\1\2\0"+
    "\2\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
            return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexerCupAnalyzer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    return ZZ_CMAP[input];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      if (zzMarkedPosL > zzStartRead) {
        switch (zzBufferL[zzMarkedPosL-1]) {
        case '\n':
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':  // fall through
          zzAtBOL = true;
          break;
        case '\r': 
          if (zzMarkedPosL < zzEndReadL)
            zzAtBOL = zzBufferL[zzMarkedPosL] != '\n';
          else if (zzAtEOF)
            zzAtBOL = false;
          else {
            boolean eof = zzRefill();
            zzMarkedPosL = zzMarkedPos;
            zzEndReadL = zzEndRead;
            zzBufferL = zzBuffer;
            if (eof) 
              zzAtBOL = false;
            else 
              zzAtBOL = zzBufferL[zzMarkedPosL] != '\n';
          }
          break;
        default:
          zzAtBOL = false;
        }
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      if (zzAtBOL)
        zzState = ZZ_LEXSTATE[zzLexicalState+1];
      else
        zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return symbol(ParserSym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { Symbol errorSymb = symbol(ParserSym.error, yytext());
                     System.out.println("Cadena ilegal <" + errorSymb.value + "> en la línea <" + errorSymb.right + ">");
                     return errorSymb;
            }
            // fall through
          case 10: break;
          case 2:
            { System.out.println("Espacio en blanco"); /*ignore*/
            }
            // fall through
          case 11: break;
          case 3:
            { /*ignore*/
            }
            // fall through
          case 12: break;
          case 4:
            { System.out.println(symbol(ParserSym.OPERADOR, yytext()).toString());
            switch (yytext()){
                case "+":
                    return symbol(ParserSym.Mas, yytext());
                case "-":
                    return symbol(ParserSym.Menos, yytext());
                case "*":
                    return symbol(ParserSym.Multiplicacion, yytext());
                case "/":
                    return symbol(ParserSym.Division, yytext());
                case "--":
                  return symbol(ParserSym.Decremento, yytext());
                case "++":
                    return symbol(ParserSym.Incremento, yytext());
                case "=":
                    return symbol(ParserSym.Igual, yytext());
                case "==":
                    return symbol(ParserSym.DobleIgual, yytext());
                case ">=":
                    return symbol(ParserSym.MayorIgual, yytext());
                case ">":
                    return  symbol(ParserSym.Mayor, yytext());
                case "<=":
                    return symbol(ParserSym.MenorIgual, yytext());
                case "<":
                    return symbol(ParserSym.Menor, yytext());
                case "!=":
                    return symbol(ParserSym.Diferente, yytext());
                case "||":
                    return symbol(ParserSym.OrDoble, yytext());
                case "&&":
                    return symbol(ParserSym.AndDoble, yytext());
                case "!":
                    return symbol(ParserSym.Not, yytext());
                case ",":
                    return symbol(ParserSym.Coma, yytext());
                case ";":
                    return symbol(ParserSym.PuntoComa, yytext());
                case "(":
                    return symbol(ParserSym.ParentesisIzq, yytext());
                case ")":
                    return symbol(ParserSym.ParentesisDer, yytext());
                case "[":
                    return symbol(ParserSym.CorcheteIzq, yytext());
                case "]":
                    return symbol(ParserSym.CorcheteDer, yytext());
                case "{":
                    return symbol(ParserSym.LlaveIzq, yytext());
                case "}":
                    return symbol(ParserSym.LlaveDer, yytext());
                case ":":
                    return symbol(ParserSym.DosPuntos, yytext());
                case ".":
                    return symbol(ParserSym.Punto, yytext());
                case "+=":
                    return symbol(ParserSym.SumaAsignacion, yytext());
                case "-=":
                    return symbol(ParserSym.RestaAsignacion, yytext());
                case "*=":
                    return symbol(ParserSym.MultiplicacionAsignacion, yytext());
                case "/=":
                    return symbol(ParserSym.DivisionAsignacion, yytext());
                case "?":
                    return symbol(ParserSym.SignoPregunta, yytext());
                case "&":
                    return symbol(ParserSym.And, yytext());
                case "^":
                    return symbol(ParserSym.Circunflejo, yytext());
                case "%":
                    return symbol(ParserSym.Modulo, yytext());
                case "|":
                    return symbol(ParserSym.Or, yytext());
                case ">>":
                    return symbol(ParserSym.DesplazamientoDerecha, yytext());
                case "<<":
                    return symbol(ParserSym.DesplazamientoIzquierda, yytext());
                case "~":
                    return symbol(ParserSym.Tilde, yytext());
                case "%=":
                    return symbol(ParserSym.ModuloAsignacion, yytext());
                case "&=":
                    return symbol(ParserSym.AndAsignacion, yytext());
                case "^=":
                    return symbol(ParserSym.CircunflejoAsignacion, yytext());
                case "|=":
                    return symbol(ParserSym.OrAsignacion, yytext());
                case "<<=":
                    return symbol(ParserSym.DesplazamientoIzquierdaAsignacion, yytext());
                case ">>=":
                    return symbol(ParserSym.DesplazamientoDerechaAsignacion, yytext());
                case "->":
                    return symbol(ParserSym.Flecha, yytext());
          }
            }
            // fall through
          case 13: break;
          case 5:
            { System.out.println(symbol(ParserSym.LITERAL, yytext()).toString());
          return symbol(ParserSym.LITERAL, yytext());
            }
            // fall through
          case 14: break;
          case 6:
            { System.out.println(symbol(ParserSym.IDENTIFICADOR, yytext()).toString());
          return symbol(ParserSym.IDENTIFICADOR, yytext());
            }
            // fall through
          case 15: break;
          case 7:
            { System.out.println("Comentarios");
            }
            // fall through
          case 16: break;
          case 8:
            { Symbol errorSymb = symbol(ParserSym.error, yytext());
            System.out.println("Cadena ilegal <" + errorSymb.value + "> en la línea <" + errorSymb.right + ">");
            return errorSymb;
            }
            // fall through
          case 17: break;
          case 9:
            { System.out.println(symbol(ParserSym.PALABRA_RESERVADA, yytext()).toString());
         /* "auto" | "break" | "case" | "char" | "continue" | "default" | "do" | "double" |
                                    "else" | "enum" | "extern" | "float" | "for" | "goto" | "if" | "int" | "long" | "register" |
                                    "return" | "short" | "signed" | "sizeof" | "static" | "struct" | "switch" | "typedef" |
                                    "union" | "unsigned" | "void" | "volatile" | "while"*/
        switch (yytext().toString()){
            case "auto":
                return symbol(ParserSym.Auto, yytext());
            case "break":
                return symbol(ParserSym.Break, yytext());
            case "case":
              return symbol(ParserSym.Case, yytext());
            case "char":
                return symbol(ParserSym.Char, yytext());
            case "const":
                return symbol(ParserSym.Const, yytext());
            case "continue":
                return symbol(ParserSym.Continue, yytext());
            case "default":
                return symbol(ParserSym.Default, yytext());
            case "do":
                return symbol(ParserSym.Do, yytext());
            case "double":
                return symbol(ParserSym.Double, yytext());
            case "else":
              return symbol(ParserSym.Else, yytext());
            case "enum":
                return symbol(ParserSym.Enum, yytext());
            case "extern":
                return symbol(ParserSym.Extern, yytext());
            case "float":
                return symbol(ParserSym.Float, yytext());
            case "for":
                return symbol(ParserSym.For, yytext());
            case "goto":
                return symbol(ParserSym.Goto, yytext());
            case "if":
              return symbol(ParserSym.If, yytext());
            case "int":
                return symbol(ParserSym.Int, yytext());
            case "long":
                return symbol(ParserSym.Long, yytext());
            case "register":
                return symbol(ParserSym.Register, yytext());
            case "return":
                return symbol(ParserSym.Return, yytext());
            case "short":
                return symbol(ParserSym.Short, yytext());
            case "signed":
              return symbol(ParserSym.Signed, yytext());
            case "sizeof":
                return symbol(ParserSym.Sizeof, yytext());
            case "static":
                return symbol(ParserSym.Static, yytext());
            case "struct":
                return symbol(ParserSym.Struct, yytext());
            case "switch":
                return symbol(ParserSym.Switch, yytext());
            case "typedef":
                return symbol(ParserSym.Typedef, yytext());
            case "union":
                return symbol(ParserSym.Union, yytext());
            case "unsigned":
                return symbol(ParserSym.Unsigned, yytext());
            case "void":
                return symbol(ParserSym.Void, yytext());
            case "volatile":
                return symbol(ParserSym.Volatile, yytext());
            case "while":
                return symbol(ParserSym.While, yytext());
            /*case "read":
                return symbol(ParserSym.Read, yytext());
            case "write":
                return symbol(ParserSym.Write, yytext());*/
        }
            }
            // fall through
          case 18: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
