package com.francisco.onepieceec03navarroinfante.data.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.francisco.onepieceec03navarroinfante.model.OnePiece;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class OnepieceDao_Impl implements OnepieceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OnePiece> __insertionAdapterOfOnePiece;

  private final EntityDeletionOrUpdateAdapter<OnePiece> __deletionAdapterOfOnePiece;

  public OnepieceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOnePiece = new EntityInsertionAdapter<OnePiece>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `onepiece` (`id`,`arctitle`,`arcdescription`,`isFavorite`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OnePiece value) {
        stmt.bindLong(1, value.getId());
        if (value.getArctitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getArctitle());
        }
        if (value.getArcdescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getArcdescription());
        }
        final int _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfOnePiece = new EntityDeletionOrUpdateAdapter<OnePiece>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `onepiece` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OnePiece value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public Object addFavorite(final OnePiece onePiece,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOnePiece.insert(onePiece);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object removeFirebase(final OnePiece onePiece,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfOnePiece.handle(onePiece);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<OnePiece> getFavorites() {
    final String _sql = "SELECT * FROM onepiece";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfArctitle = CursorUtil.getColumnIndexOrThrow(_cursor, "arctitle");
      final int _cursorIndexOfArcdescription = CursorUtil.getColumnIndexOrThrow(_cursor, "arcdescription");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final List<OnePiece> _result = new ArrayList<OnePiece>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OnePiece _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpArctitle;
        if (_cursor.isNull(_cursorIndexOfArctitle)) {
          _tmpArctitle = null;
        } else {
          _tmpArctitle = _cursor.getString(_cursorIndexOfArctitle);
        }
        final String _tmpArcdescription;
        if (_cursor.isNull(_cursorIndexOfArcdescription)) {
          _tmpArcdescription = null;
        } else {
          _tmpArcdescription = _cursor.getString(_cursorIndexOfArcdescription);
        }
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new OnePiece(_tmpId,_tmpArctitle,_tmpArcdescription,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
