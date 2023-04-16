package com.technoship123.jetbrainsmoyaiplugin.listeners;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.technoship123.jetbrainsmoyaiplugin.Moyai;
import org.jetbrains.annotations.NotNull;

class MoyaiTypedHandler extends TypedHandlerDelegate {
    private static final String MOYAI_KEYWORD = "moyai";
    private static final String MOYAI_EMOJI = "\uD83D\uDDFF";
    private String lastWord = "";

    @Override
    public @NotNull Result beforeCharTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, @NotNull FileType fileType) {
        // Get the current line text
        Document document = editor.getDocument();
        int caretOffset = editor.getCaretModel().getOffset();
        int lineNumber = document.getLineNumber(caretOffset);
        String lineText;
        try {
            lineText = document.getText(new TextRange(document.getLineStartOffset(lineNumber), caretOffset + 1));
        } catch (IndexOutOfBoundsException ignored) {
            lineText = document.getText(new TextRange(document.getLineStartOffset(lineNumber), caretOffset));
        }

        String[] words = lineText.split("\\s+");
        String currentWord;
        if (words.length > 0)
            currentWord = words[words.length - 1];
        else
            return Result.CONTINUE;

        if (!currentWord.equals(lastWord)) {
            lastWord = currentWord; // Update the last word
            // Check if the current word contains the "moyai" keyword
            if (currentWord.contains(MOYAI_KEYWORD) || currentWord.contains(MOYAI_EMOJI)) {
                // System.out.println("Detected 'moyai' in word: " + currentWord);
                Moyai.playSound();
            }
        }
        return Result.CONTINUE;
    }
}
