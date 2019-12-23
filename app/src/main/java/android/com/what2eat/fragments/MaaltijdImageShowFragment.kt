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
 * [Fragment] voor het weergeven van een afbeelding van een maaltijd.
 */
class MaaltijdImageShowFragment : Fragment() {
    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdImageShowBinding
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     */
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

        return binding.root
    }

    /**
     * Deze functie wordt gebruikt voor het weergeven van een afbeelding van een maaltijd.
     * De URI van de foto wordt gecommuniceerd via SafeArgs en wordt geroteerd naargelang de positie van de afbeelding.
     */
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
