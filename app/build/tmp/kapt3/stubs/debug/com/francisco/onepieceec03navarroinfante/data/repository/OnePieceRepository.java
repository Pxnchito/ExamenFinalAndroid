package com.francisco.onepieceec03navarroinfante.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/francisco/onepieceec03navarroinfante/data/repository/OnePieceRepository;", "", "onepieceDao", "Lcom/francisco/onepieceec03navarroinfante/data/db/OnepieceDao;", "(Lcom/francisco/onepieceec03navarroinfante/data/db/OnepieceDao;)V", "getOnepieceDao", "()Lcom/francisco/onepieceec03navarroinfante/data/db/OnepieceDao;", "addFavorite", "", "onePiece", "Lcom/francisco/onepieceec03navarroinfante/model/OnePiece;", "(Lcom/francisco/onepieceec03navarroinfante/model/OnePiece;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "", "getOnePieces", "Lcom/francisco/onepieceec03navarroinfante/data/response/ApiResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFirebase", "app_debug"})
public final class OnePieceRepository {
    @org.jetbrains.annotations.Nullable
    private final com.francisco.onepieceec03navarroinfante.data.db.OnepieceDao onepieceDao = null;
    
    public OnePieceRepository() {
        super();
    }
    
    public OnePieceRepository(@org.jetbrains.annotations.Nullable
    com.francisco.onepieceec03navarroinfante.data.db.OnepieceDao onepieceDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.francisco.onepieceec03navarroinfante.data.db.OnepieceDao getOnepieceDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOnePieces(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.francisco.onepieceec03navarroinfante.data.response.ApiResponse<java.util.List<com.francisco.onepieceec03navarroinfante.model.OnePiece>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull
    com.francisco.onepieceec03navarroinfante.model.OnePiece onePiece, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object removeFirebase(@org.jetbrains.annotations.NotNull
    com.francisco.onepieceec03navarroinfante.model.OnePiece onePiece, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.francisco.onepieceec03navarroinfante.model.OnePiece> getFavorites() {
        return null;
    }
}