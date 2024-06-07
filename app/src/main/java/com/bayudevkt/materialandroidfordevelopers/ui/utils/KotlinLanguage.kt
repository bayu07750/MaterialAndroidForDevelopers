package com.bayudevkt.materialandroidfordevelopers.ui.utils

import android.content.Context
import com.amrdeveloper.codeview.CodeView
import com.bayudevkt.materialandroidfordevelopers.R
import java.util.regex.Pattern

object KotlinLanguage {

    private val PATTERN_KEYWORDS: Pattern = Pattern.compile(
        "\\b(abstract|boolean|break|byte|case|catch" +
                "|char|class|continue|default|do|double|else" +
                "|enum|extends|final|finally|float|for|if" +
                "|implements|import|instanceof|int|interface" +
                "|long|native|new|null|package|private|protected" +
                "|public|return|short|static|strictfp|super|switch" +
                "|synchronized|this|throw|transient|try|void|volatile|while" +
                "|when|data|object|sealed|var|val|const|init|get|set|by|override" +
                "|suspend|inline|infix|crossinline|noinline|fun" +
                "sealed|varrarg|reified|tailrec|internal|open|lateinit)\\b"
    )

    private val PATTERN_BUILTINS: Pattern = Pattern.compile("[,:;[->]{}()]")
    private val PATTERN_SINGLE_LINE_COMMENT: Pattern = Pattern.compile("//[^\\n]*")
    private val PATTERN_MULTI_LINE_COMMENT: Pattern = Pattern.compile("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/")
    private val PATTERN_ATTRIBUTE: Pattern = Pattern.compile("\\.[a-zA-Z0-9_]+")
    private val PATTERN_OPERATION: Pattern =
        Pattern.compile(":|==|>|<|!=|>=|<=|->|=|>|<|%|-|-=|%=|\\+|\\-|\\-=|\\+=|\\^|\\&|\\|::|\\?|\\*")
    private val PATTERN_GENERIC: Pattern = Pattern.compile("<[a-zA-Z0-9,<>]+>")
    private val PATTERN_ANNOTATION: Pattern = Pattern.compile("@.[a-zA-Z0-9]+")
    private val PATTERN_TODO_COMMENT: Pattern = Pattern.compile("//TODO[^\n]*")
    private val PATTERN_NUMBERS: Pattern = Pattern.compile("\\b(\\d*[.]?\\d+)\\b")
    private val PATTERN_CHAR: Pattern = Pattern.compile("['](.*?)[']")
    private val PATTERN_STRING: Pattern = Pattern.compile("[\"](.*?)[\"]")
    private val PATTERN_HEX: Pattern = Pattern.compile("0x[0-9a-fA-F]+")
    fun applyFiveColorsDarkTheme(context: Context, codeView: CodeView) {
        codeView.resetSyntaxPatternList()
        codeView.resetHighlighter()

        val resources = context.resources

        //View Background
        codeView.setBackgroundColor(resources.getColor(R.color.five_dark_black))

        //Syntax Colors
        codeView.addSyntaxPattern(
            PATTERN_HEX,
            resources.getColor(R.color.five_dark_purple)
        )
        codeView.addSyntaxPattern(
            PATTERN_CHAR,
            resources.getColor(R.color.five_dark_yellow)
        )
        codeView.addSyntaxPattern(
            PATTERN_STRING,
            resources.getColor(R.color.five_dark_yellow)
        )
        codeView.addSyntaxPattern(
            PATTERN_NUMBERS,
            resources.getColor(R.color.five_dark_purple)
        )
        codeView.addSyntaxPattern(
            PATTERN_KEYWORDS,
            resources.getColor(R.color.five_dark_purple)
        )
        codeView.addSyntaxPattern(
            PATTERN_BUILTINS,
            resources.getColor(R.color.five_dark_white)
        )
        codeView.addSyntaxPattern(
            PATTERN_SINGLE_LINE_COMMENT,
            resources.getColor(R.color.five_dark_grey)
        )
        codeView.addSyntaxPattern(
            PATTERN_MULTI_LINE_COMMENT,
            resources.getColor(R.color.five_dark_grey)
        )
        codeView.addSyntaxPattern(
            PATTERN_ANNOTATION,
            resources.getColor(R.color.five_dark_purple)
        )
        codeView.addSyntaxPattern(
            PATTERN_ATTRIBUTE,
            resources.getColor(R.color.five_dark_blue)
        )
        codeView.addSyntaxPattern(
            PATTERN_GENERIC,
            resources.getColor(R.color.five_dark_purple)
        )
        codeView.addSyntaxPattern(
            PATTERN_OPERATION,
            resources.getColor(R.color.five_dark_purple)
        )

        //Default Color
        codeView.setTextColor(resources.getColor(R.color.five_dark_white))

        codeView.addSyntaxPattern(
            PATTERN_TODO_COMMENT,
            resources.getColor(R.color.gold)
        )

        codeView.reHighlightSyntax()
    }
}