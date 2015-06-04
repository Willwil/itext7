package com.itextpdf.core.pdf.action;

import com.itextpdf.core.pdf.*;
import com.itextpdf.core.pdf.annot.PdfAnnotation;
import com.itextpdf.core.pdf.filespec.PdfFileSpec;
import com.itextpdf.core.pdf.filespec.PdfStringFS;
import com.itextpdf.core.pdf.navigation.PdfDestination;
import com.itextpdf.core.pdf.navigation.PdfExplicitDestination;
import com.itextpdf.core.pdf.navigation.PdfStringDestination;

import java.util.List;

public class PdfAction extends PdfObjectWrapper<PdfDictionary> {

    public PdfAction(PdfDocument document) {
        this(new PdfDictionary(), document);
        put(PdfName.Type, PdfName.Action);
    }

    public PdfAction(PdfDictionary pdfObject, PdfDocument pdfDocument) {
        super(pdfObject, pdfDocument);
    }

    static public PdfAction createGoTo(PdfDocument pdfDocument, PdfDestination destination) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.GoTo).put(PdfName.D, destination);
    }

    static public PdfAction createGoTo(PdfDocument pdfDocument, String destination) {
        return createGoTo(pdfDocument, new PdfStringDestination(destination));
    }

    static public PdfAction createGoToR(PdfDocument pdfDocument, PdfFileSpec fileSpec, PdfDestination destination, boolean newWindow) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.GoToR).put(PdfName.F, fileSpec).
                put(PdfName.D, destination).put(PdfName.NewWindow, new PdfBoolean(newWindow));
    }

    static public PdfAction createGoToR(PdfDocument pdfDocument, PdfFileSpec fileSpec, PdfDestination destination) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.GoToR).put(PdfName.F, fileSpec).
                put(PdfName.D, destination);
    }

    static public PdfAction createGoToR(PdfDocument pdfDocument, String filename, int pageNum) {
        return createGoToR(pdfDocument, filename, pageNum, false);
    }

    static public PdfAction createGoToR(PdfDocument pdfDocument, String filename, int pageNum, boolean newWindow) {
        return createGoToR(pdfDocument, new PdfStringFS(filename), new PdfExplicitDestination().createFitH(pageNum, 10000), newWindow);
    }

    static public PdfAction createGoToR(PdfDocument pdfDocument, String filename, String destination, boolean newWindow) {
        return createGoToR(pdfDocument, new PdfStringFS(filename), new PdfStringDestination(destination), newWindow);
    }

    static public PdfAction createGoToR(PdfDocument pdfDocument, String filename, String destination) {
        return createGoToR(pdfDocument, filename, destination, false);
    }

    static public PdfAction createGoToE(PdfDocument pdfDocument, PdfDestination destination, boolean newWindow, PdfTargetDictionary targetDictionary) {
        return createGoToE(pdfDocument, null, destination, newWindow, targetDictionary);
    }

    static public PdfAction createGoToE(PdfDocument pdfDocument, PdfFileSpec fileSpec, PdfDestination destination, boolean newWindow, PdfTargetDictionary targetDictionary) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.GoToE).put(PdfName.F, fileSpec).put(PdfName.D, destination).
                put(PdfName.NewWindow, new PdfBoolean(newWindow)).put(PdfName.T, targetDictionary);
    }

    static public PdfAction createLaunch(PdfDocument pdfDocument, PdfFileSpec fileSpec, boolean newWindow) {
        return createLaunch(pdfDocument, fileSpec, null, newWindow);
    }

    static public PdfAction createLaunch(PdfDocument pdfDocument, PdfFileSpec fileSpec) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Launch).put(PdfName.F, fileSpec);
    }

    static public PdfAction createLaunch(PdfDocument pdfDocument, PdfFileSpec fileSpec, PdfWin win, boolean newWindow) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Launch).put(PdfName.F, fileSpec).put(PdfName.Win, win).
                put(PdfName.NewWindow, new PdfBoolean(newWindow));
    }

    static public PdfAction createThread(PdfDocument pdfDocument, PdfFileSpec fileSpec, PdfObject destinationThread, PdfObject bead) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Launch).put(PdfName.F, fileSpec).
                put(PdfName.D, destinationThread).put(PdfName.B, bead);
    }

    static public PdfAction createThread(PdfDocument pdfDocument, PdfFileSpec fileSpec) {
        return createThread(pdfDocument, fileSpec, null, null);
    }

    static public PdfAction createURI(PdfDocument pdfDocument, String uri) {
        return createURI(pdfDocument, uri, false);
    }

    static public PdfAction createURI(PdfDocument pdfDocument, String uri, boolean isMap) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.URI).put(PdfName.URI, new PdfString(uri)).put(PdfName.IsMap, new PdfBoolean(isMap));
    }

    static public PdfAction createSound(PdfDocument pdfDocument, PdfStream sound) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Sound).put(PdfName.Sound, sound);
    }

    static public PdfAction createSound(PdfDocument pdfDocument, PdfStream sound, float volume, boolean synchronous, boolean repeat, boolean mix) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Sound).put(PdfName.Sound, sound).
                put(PdfName.Volume, new PdfNumber(volume)).put(PdfName.Synchronous, new PdfBoolean(synchronous)).
                put(PdfName.Repeat, new PdfBoolean(repeat)).put(PdfName.Mix, new PdfBoolean(mix));
    }

    static public PdfAction createMovie(PdfDocument pdfDocument, PdfAnnotation annotation, String title, PdfName operation) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Movie).put(PdfName.Annotation, annotation).
                put(PdfName.T, new PdfString(title)).put(PdfName.Operation, operation);
    }

    static public PdfAction createHide(PdfDocument pdfDocument, PdfAnnotation annotation, boolean hidden) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Hide).put(PdfName.T, annotation).
                put(PdfName.H, new PdfBoolean(hidden));
    }

    static public PdfAction createHide(PdfDocument pdfDocument, PdfAnnotation[] annotations, boolean hidden) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Hide).put(PdfName.T, getArrayFromWrappersList(annotations)).
                put(PdfName.H, new PdfBoolean(hidden));
    }

    static public PdfAction createHide(PdfDocument pdfDocument, String text, boolean hidden) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Hide).put(PdfName.T, new PdfString(text)).
                put(PdfName.H, new PdfBoolean(hidden));
    }

    static public PdfAction createHide(PdfDocument pdfDocument, String[] text, boolean hidden) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Hide).put(PdfName.T, getArrayFromStringList(text)).
                put(PdfName.H, new PdfBoolean(hidden));
    }

    static public PdfAction createNamed(PdfDocument pdfDocument, PdfName namedAction) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Named).put(PdfName.N, namedAction);
    }

    static public PdfAction createSetOcgState(PdfDocument pdfDocument, List<PdfActionOcgState> states) {
        return createSetOcgState(pdfDocument, states, false);
    }

    static public PdfAction createSetOcgState(PdfDocument pdfDocument, List<PdfActionOcgState> states, boolean preserveRb) {
        PdfArray stateArr = new PdfArray();
        for (PdfActionOcgState state : states)
            stateArr.addAll(state.getObjectList());
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.SetOCGState).put(PdfName.State, stateArr).put(PdfName.PreserveRB, new PdfBoolean(preserveRb));
    }


    public static PdfAction createRendition(PdfDocument pdfDocument, String file, PdfFileSpec fs, String mimeType, PdfAnnotation screenAnnotation) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.Rendition).
                put(PdfName.OP, new PdfNumber(0)).put(PdfName.AN, screenAnnotation).
                put(PdfName.R, new PdfRendition(pdfDocument, file, fs, mimeType));
    }


    static public PdfAction createJavaScript(PdfDocument pdfDocument, String javaScript) {
        return new PdfAction(pdfDocument).put(PdfName.S, PdfName.JavaScript).put(PdfName.JS, new PdfString(javaScript));
    }

    static public void setAdditionalAction(PdfObjectWrapper<PdfDictionary> wrapper, PdfName key, PdfAction action) {
        PdfDictionary dic;
        PdfObject obj = wrapper.getPdfObject().get(PdfName.AA);
        if (obj != null && obj.isDictionary())
            dic = (PdfDictionary) obj;
        else
            dic = new PdfDictionary();
        dic.put(key, action.getPdfObject());
        wrapper.put(PdfName.AA, dic);
    }


    /**
     * Add a chained action.
     *
     * @param na
     */
    public void next(PdfAction na) {
        PdfObject nextAction = getPdfObject().get(PdfName.Next);
        if (nextAction == null)
            put(PdfName.Next, na);
        else if (nextAction.isDictionary()) {
            PdfArray array = new PdfArray(nextAction);
            array.add(na.getPdfObject());
            put(PdfName.Next, array);
        } else {
            ((PdfArray) nextAction).add(na.getPdfObject());
        }
    }

    private static PdfArray getArrayFromWrappersList(PdfObjectWrapper[] wrappers) {
        PdfArray arr = new PdfArray();
        for (PdfObjectWrapper wrapper : wrappers) {
            arr.add(wrapper.getPdfObject());
        }
        return arr;
    }

    private static PdfArray getArrayFromStringList(String[] strings) {
        PdfArray arr = new PdfArray();
        for (String string : strings) {
            arr.add(new PdfString(string));
        }
        return arr;
    }

}
