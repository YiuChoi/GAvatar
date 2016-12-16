package name.caiyao.gavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by 蔡小木 on 2016/12/14 0014.
 */

public class Utils {

    public static Bitmap generate(Context context, Gender gender) {
        Bitmap bitmap = null;
        try {
            Bitmap background = BitmapFactory.decodeStream(getData(context, "background"));
            Bitmap face = BitmapFactory.decodeStream(getData(context, gender.getGenderName() + "/face"));
            Bitmap clothes = BitmapFactory.decodeStream(getData(context, gender.getGenderName() + "/clothes"));
            Bitmap mouth = BitmapFactory.decodeStream(getData(context, gender.getGenderName() + "/mouth"));
            Bitmap hair = BitmapFactory.decodeStream(getData(context, gender.getGenderName() + "/hair"));
            Bitmap eye = BitmapFactory.decodeStream(getData(context, gender.getGenderName() + "/eye"));

            bitmap = Bitmap.createBitmap(background.getWidth(), background.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(background, 0, 0, null);
            canvas.drawBitmap(face, 0, 0, null);
            canvas.drawBitmap(clothes, 0, 0, null);
            canvas.drawBitmap(mouth, 0, 0, null);
            canvas.drawBitmap(hair, 0, 0, null);
            canvas.drawBitmap(eye, 0, 0, null);
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static InputStream getData(Context context, String path) throws IOException {
        String[] data = context.getAssets().list(path);
        return context.getAssets().open(path + "/" + data[randomInt(data.length)]);
    }

    private static int randomInt(int max) {
        return new Random().nextInt(max);
    }
}
