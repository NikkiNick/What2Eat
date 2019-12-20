package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.databinding.FragmentMaaltijdImageShowBinding
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdImageShowFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdImageShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_maaltijd_image_show,
            container,
            false
        )

        showAndRotateImage()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun showAndRotateImage(){
        val args = MaaltijdImageShowFragmentArgs.fromBundle(arguments!!)
        val image: Bitmap = BitmapFactory.decodeFile(args.maaltijdPhotoUri)
        val windowOrientation = activity!!.resources.configuration.orientation
        var imageOrientation = Configuration.ORIENTATION_PORTRAIT
        if(image.width > image.height){
            imageOrientation = Configuration.ORIENTATION_LANDSCAPE
        }
        if (imageOrientation != windowOrientation) {
            val matrix = Matrix()
            matrix.postRotate(90F)
            val scaledBitmap: Bitmap =
                Bitmap.createScaledBitmap(image, image.width, image.height, true)
            val rotatedBitmap: Bitmap = Bitmap.createBitmap(
                scaledBitmap,
                0,
                0,
                scaledBitmap.getWidth(),
                scaledBitmap.getHeight(),
                matrix,
                true
            )
            Glide.with(context!!).load(rotatedBitmap).into(binding.maaltijdImage)
        } else {
            Glide.with(context!!).load(args.maaltijdPhotoUri).into(binding.maaltijdImage)
        }
    }
}
